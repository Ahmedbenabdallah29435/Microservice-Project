package com.example.sellers.domain;


import com.example.sellers.model.StatutContrat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class SellContract {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int contractsellid;

   

    @Column
    private Double price;

    @Column
    private LocalDate selldate;

    @Column
    private String city;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_sell_id")
    private SellerOffer contractSell;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_contractsale_id")
    private User userContractsale;







}
