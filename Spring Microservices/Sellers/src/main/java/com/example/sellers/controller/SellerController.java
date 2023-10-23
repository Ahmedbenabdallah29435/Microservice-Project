package com.example.sellers.controller;



import com.example.sellers.domain.*;
import com.example.sellers.model.SellContractDTO;
import com.example.sellers.model.SellerOfferDTO;
import com.example.sellers.model.TypeOffer;
import com.example.sellers.repositories.OfferFavoriteRepository;
import com.example.sellers.repositories.SellerOfferRepository;
import com.example.sellers.services.IContratService;
import com.example.sellers.services.ISellerService;
import com.example.sellers.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Date;
import java.util.List;



@RestController
@RequestMapping(value = "/api/seller")
@CrossOrigin(origins = "*")

public class SellerController {
    @Autowired
    private SellerOfferRepository sellerOfferRepository;
    @Autowired
    private ISellerService sellerService;
    @Autowired
    private IContratService contratService;

    @Autowired
    private OfferFavoriteRepository offerFavoriteRepository;
    @Autowired
    private ISellerService favoritOffer;

    @PostMapping("uploadImage/{user_id}")
    public void createUser(@RequestParam("description") String description,
                           @RequestParam("title") String title, @RequestParam("address") String address, @RequestParam("datesell") Date datesell, @RequestParam("price") double price, @RequestParam(value = "image", required = false) MultipartFile image, @RequestParam("typeoffer") TypeOffer typeoffer, @RequestParam("surface")Double surface, @PathVariable("user_id") int user_id) throws IOException {
        SellerOffer offre = new SellerOffer();
        offre.setDescription(description);
        offre.setAddress(address);
        offre.setTitle(title);
        offre.setDatesell(datesell);
        offre.setPrice(price);
        offre.setTypeoffer(typeoffer);
        offre.setSurface(surface);

        if (image != null) {
            String imagePath = SellerService.saveImage(image);
            offre.setPicture(imagePath);
        }
        SellerOffer savedOffer = sellerService.saveoffer(offre,user_id);
        ResponseEntity.ok(savedOffer);
    }


    @PostMapping("addOffer/{user_id}")
    public void addOffer(@RequestBody SellerOffer sellerOffer,@PathVariable("user_id") int user_id)
    {
        sellerService.ajouterOffer(sellerOffer,user_id);

    }
    @GetMapping("/offers/interesse")
    public ResponseEntity<List<SellerOfferDTO>> getinteresseOffers() {
        return ResponseEntity.ok(sellerService.findAllOfferFavorit1());

    }

    @PutMapping("updateOffer")
    void updateOffer(@RequestBody SellerOffer c)
    {

        sellerService.updateOffer(c);
    }
    @DeleteMapping("deleteOffer/{idc}")
    void deleteOffer(@PathVariable("idc") int idc)
    {

        sellerService.deleteOffer(idc);
    }



    @GetMapping("getbyId/{sellid}")
    public ResponseEntity<SellerOfferDTO> getSellerOffer(
            @PathVariable(name = "sellid") final Integer sellid) {
        return ResponseEntity.ok(sellerService.getById(sellid));
    }
    @GetMapping("findAll")
    public ResponseEntity<List<SellerOfferDTO>> getAllSellerOffers() {
        return ResponseEntity.ok(sellerService.findAll());
    }
    @GetMapping("/findByPrice")
    public ResponseEntity<List<SellerOfferDTO>> getPriceOffreAsc(){
        return ResponseEntity.ok( sellerService.findOffreByPriceASC());
    }
    @GetMapping("offreBySurface/{minSurface}/{maxSurface}")
    public ResponseEntity<List<SellerOfferDTO>> findBySurfaceBetween(@PathVariable("minSurface") Double minSurface,
                                                                     @PathVariable("maxSurface") Double maxSurface) {
        return ResponseEntity.ok( sellerService.findBySurfaceBetween(minSurface, maxSurface));
    }


    @PutMapping("sold/{id}")
    public ResponseEntity<?> markAsSold(@PathVariable Long id) {
        sellerService.markAsSold(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("favorite/{id}")
    public ResponseEntity<?> markOfferAsFavorite(@PathVariable Integer id) {
        sellerService.markOfferAsFavorite(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("favorite")
    public List<OffreFavorit> findAllOfferfavorit(){
        return favoritOffer.findAllOfferFavorit();
    }

    @DeleteMapping("deleteOfferFavorit/{idc}")
    void deleteOfferFavorit(@PathVariable("idc") int idc)
    {

        sellerService.deleteOfferFavorit(idc);
    }



    @PostMapping("demanderRendezVous/{idOffre}")
    public void demanderRendezVous(@RequestBody RendezVous rendezVous, @PathVariable int idOffre) {
        sellerService.demanderRendezVous(idOffre, rendezVous);
    }
    @PostMapping("addContrat/{user_id}/{sell_id}")
    public int addContrat(@RequestBody SellContract contract, @PathVariable("user_id") int user_id, @PathVariable("sell_id") int sellid)
    {
        contratService.ajouterContrat(contract,user_id,sellid);
        return contract.getContractsellid();
    }
    @PutMapping("updateContrat")
    void updateContract(@RequestBody SellContract c)
    {

        contratService.updateContrat(c);
    }
    @DeleteMapping("deleteContrat/{idc}")
    void deleteContract(@PathVariable("idc") int id)
    {

        contratService.deleteContrat(id);
    }
    @GetMapping("getContrat/{contractsellid}")
    public ResponseEntity<SellContractDTO> getSellContract(
            @PathVariable(name = "contractsellid") final Integer contractsellid) {
        return ResponseEntity.ok(contratService.get(contractsellid));
    }



    @GetMapping("AllContrat")
    public ResponseEntity<List<SellContractDTO>> getAllSellContracts() {
        return ResponseEntity.ok(contratService.findAll());
    }




}







