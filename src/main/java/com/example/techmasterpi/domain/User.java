package com.example.techmasterpi.domain;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.util.Set;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter




@AllArgsConstructor
@NoArgsConstructor

@Table(name = "`user`")

public class User  {
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






    @OneToMany(mappedBy = "userRentalcontract")
    private Set<RentalContract> userRentalcontractRentalContracts;




}