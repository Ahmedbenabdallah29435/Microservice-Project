package com.example.sellers.model;

import lombok.Getter;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
public class SellerOfferDTO {

    private Integer sellid;


    private String description;


    private String title;

    private double price;


    private String address;

    private Date datesell;
    private Double surface;

    private Boolean sold=false;

    private Boolean favorite=false ;


    private String picture;

    private TypeOffer typeoffer;
    private StatutOffre statut;

    private Date rendezvousdate;

    private Integer userSell;

    private Integer contractSell;

}
