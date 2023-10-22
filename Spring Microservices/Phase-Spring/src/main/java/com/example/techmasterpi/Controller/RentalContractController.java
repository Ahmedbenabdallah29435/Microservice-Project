package com.example.techmasterpi.Controller;

import com.example.techmasterpi.domain.RentalContract;
import com.example.techmasterpi.model.RentalContractDTO;
import com.example.techmasterpi.repos.RentalContractRepository;
import com.example.techmasterpi.service.IRentalContract;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/rentalcontract")

public class RentalContractController {
    @Autowired
    IRentalContract rentalContractService;

    @Autowired
    RentalContractRepository rentalContractRepository;

    @GetMapping("/GetAllRentalContract")
    public ResponseEntity<List<RentalContractDTO>> getAllRentalContracts(){
        List<RentalContractDTO> rentalContracts = rentalContractService.findAll();
        if(rentalContracts.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(rentalContracts);
        }
    }

    @GetMapping("/getRentalContract/{rc}")
    public ResponseEntity<?> getRentalOffer(@PathVariable("rc") int rc) {
        RentalContractDTO rentalContractDTO = rentalContractService.getById(rc);
        if (rentalContractDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rentalContractDTO);
        }
    }

    @PostMapping("/addRentalContract/{userId}/{rentalOfferId}")
    public ResponseEntity<String> addContrat(@RequestBody RentalContract rc, @PathVariable("userId") int userId, @PathVariable("rentalOfferId") int rentalOfferId) throws MessagingException {
        try {
            int contratId = rentalContractService.addRentalContract(rc, userId, rentalOfferId);
            return ResponseEntity.ok("Le contrat a été ajouté avec succès. Identifiant de contrat : " + contratId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de l'ajout du contrat : " + e.getMessage());
        }
    }


    @PutMapping("/updateRentalContract")
    public ResponseEntity<String> updateContrat(@RequestBody RentalContract rc) {
        boolean updated = rentalContractService.updateRentalContract(rc);
        if (updated) {
            return ResponseEntity.ok("Rental contract updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update rental contract.");
        }
    }

    @DeleteMapping("/deleteRentalContract/{rc}")
    public ResponseEntity<String> deleteRentalOffer(@PathVariable("rc") int rc) {
        boolean deleted = rentalContractService.deleteRentalContract(rc);
        if (deleted) {
            return ResponseEntity.ok("Rental contract deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rental contract not found.");
        }
    }


    @GetMapping("/revenue/{userId}")
    public ResponseEntity<String> calculateRevenueForUser(@PathVariable int userId) {
        Double revenue = rentalContractService.getChiffreAffaireByUser(userId);
        if (revenue != null) {
            return ResponseEntity.ok("Chiffre d'affaires pour l'utilisateur " + userId + " : " + revenue);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aucun chiffre d'affaires n'a été trouvé pour l'utilisateur " + userId + ".");
        }
    }

    @GetMapping("/export/{id}")
    public ResponseEntity<Resource> exportContrat(@PathVariable int id) throws IOException {

        String filename = "contract_" + id + ".pdf";
        String filePath = "C:/Users/khali/Desktop/" + filename; // Update with your actual desktop path

        // Export the contract to PDF
        rentalContractService.exportcontrat(id, filePath);

        // Prepare the file as a Resource
        File file = new File(filePath);
        Path path = file.toPath();
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

        // Return the file as a ResponseEntity
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);

    }


    @PostMapping("/charge")
    public ResponseEntity<Charge> createCharge(@RequestParam("token") String token,
                                               @RequestParam("amount") int amount,
                                               @RequestParam("currency") String currency,
                                               @RequestParam ("id") int id
    ) throws StripeException
    {

        Charge charge = rentalContractService.createCharge(token,amount,currency,id);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



/*
    @GetMapping("/getContractFinAbonnement")
    public List<RentalContract> getContractFinAbonnement(){
        return rentalContractService.rappelFinContrat();
    }*/
}
