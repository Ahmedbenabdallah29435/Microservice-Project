package com.example.techmasterpi.service;

import com.example.techmasterpi.domain.RentalOffer;
import com.example.techmasterpi.model.RentalOfferDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IRentalOffer {

    public List<RentalOfferDTO> findRentalOfferByTitle(String title);
    public List<RentalOfferDTO> findAllOrderByPriceAsc();
    int addRentalOffer(RentalOffer rentalOffer,int idUser);
    boolean updateRentalOffer(RentalOffer rentalOffer);
    boolean deleteRentalOffer(int id);
    RentalOfferDTO getById(final Integer offreid);
   public List<RentalOfferDTO> getAll();
    double getChiffreAffaireByOffer(int offerId);
    //public List<RentalOfferDTO> findAll();
    public List<RentalOfferDTO> getOffersByRangePrice(double price1, double price2);
    public  List<RentalOfferDTO> findTopNByOrderByOffredateDesc(Integer n);
}
