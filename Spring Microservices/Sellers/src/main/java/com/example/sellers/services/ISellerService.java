package com.example.sellers.services;

import com.example.sellers.domain.OffreFavorit;
import com.example.sellers.domain.RendezVous;
import com.example.sellers.domain.SellerOffer;
import com.example.sellers.model.SellerOfferDTO;

import java.util.List;

public interface ISellerService {


    public SellerOffer ajouterOffer (SellerOffer sellerOffer,int id);

//    public SellerOffer saveoffer(SellerOffer sellerOffer,int id);
public SellerOffer saveoffer(SellerOffer sellerOffer,int user_id);
    public SellerOffer demanderRendezVous(int idOffre, RendezVous rendezVous);


    public void updateOffer (SellerOffer s);
    void deleteOffer(int id);
    public void deleteOfferFavorit(int id);

    public SellerOfferDTO getById(final Integer planid);
//    SellerOffer get(int id);

//    public List<SellerOffer> findAllOffer();
    public void markAsSold(Long id);
    public List<SellerOfferDTO> findAll();
//    public List<SellerOffer> findOffreByPriceASC();
public List<SellerOfferDTO> findOffreByPriceASC();
//    public Note donnerRating(Note note, int offreId, int user_id, int noteSur10);
public List<SellerOfferDTO> findBySurfaceBetween(Double minSurface, Double maxSurface);


  void markOfferAsFavorite(Integer id);
//    public List<SellerOffer> getFavoriteOffers();
//    public SellerOffer MarkOfferAsFavorite(SellerOffer offer);
//    List<SellerOffer> findByHistorique();
//
public List<OffreFavorit> findAllOfferFavorit();

    List<SellerOfferDTO> findAllOfferFavorit1();





}
