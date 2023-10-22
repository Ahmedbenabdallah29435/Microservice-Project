package com.esprit.microservices.candidate.domain;

import io.micrometer.core.lang.Nullable;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private int cin;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int phone;
    private String address;
    @Nullable
    private String profilepicture;
    @Nullable
    private String companyname;




    public int getUserid() {
        return userid;
    }

    public int getCin() {
        return cin;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Nullable
    public String getProfilepicture() {
        return profilepicture;
    }

    @Nullable
    public String getCompanyname() {
        return companyname;
    }

    public LocalDateTime lastLoggedIn;



    @OneToMany(mappedBy = "planUser")
    @JsonIgnore
    private Set<ContractPlan> planUser;















}