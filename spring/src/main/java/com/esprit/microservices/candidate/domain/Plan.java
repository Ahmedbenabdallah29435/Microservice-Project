package com.esprit.microservices.candidate.domain;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;


@Entity
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter

public class Plan {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer planid;

    @Column
    private String title;

    @Column
    private String picture;

    @Column
    private Double price;

    @Column
    private Double realizationprice;

    @Column
    private Integer livingroom;

    @Column
    private Integer kitchen;

    @Column
    private Integer wc;

    @Column
    private Integer room1;

    @Column
    private Integer room2;

    @Column

    private String description;

    @OneToMany(mappedBy = "planContractPlan")
    private Set<ContractPlan> planContractPlanContractPlans;

    @ManyToOne
    @JsonIgnore
    private User user;
    private Integer userId;

    public Plan(String title, Double price, Double realizationprice, Integer livingroom, Integer kitchen, Integer wc, Integer room1, Integer room2, String description) {
    }

    public Plan() {

    }
}
