package com.example.techmasterpi.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class RentalOffer {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer offreid;

    @Column
    private String title;

    @Column(name = "\"description\"")
    private String description;

    @Column
    private String adress;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")

    private LocalDate offredate;

    @Column
    private String picture;

    @Column
    private Double monthlyrent;

    @Column
    private String typerentalloffer;



    @OneToMany(mappedBy = "rentalofferRentalContract")
    private Set<RentalContract> rentalofferRentalContractRentalContracts;


    @ManyToOne
    @JoinColumn(name = "user_userid")
    private User user;

}
