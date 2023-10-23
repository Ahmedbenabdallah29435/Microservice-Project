package com.example.sellers.domain;


import com.example.sellers.model.StatutOffre;
import com.example.sellers.model.TypeOffer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter

@AllArgsConstructor


public class SellerOffer {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int sellid;

    @Column
    private String description;


    @Column
    private String title;

    @Column

    private double price;

    @Column
    private String address;

    @Column
    private Date datesell;

    @Column
    private String picture;
    @Column
    private Boolean sold=false;
    @Column
    private Boolean favorite =false;


    @Column
    @Enumerated(EnumType.STRING)
    private TypeOffer typeoffer;

    @Column
    @Enumerated(EnumType.STRING)
    private StatutOffre statut = StatutOffre.EN_ATTENTE;
    @Column
    private Date rendezvousdate;






    @OneToMany(mappedBy = "contractSell")

    private Set<SellContract> sellContracts;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "sellerOffer")
    private List<OffreFavorit> offreFavorits;

    @OneToMany(mappedBy = "offerRendezVous")
    private List<RendezVous> rendezVous;

    private Double surface;

    private int rating;



    }




