package tn.esprit.spring.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString

@RequiredArgsConstructor


public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long IdClient;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryClient categoryClient;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Profession profession;

    @OneToMany(mappedBy = "client")
    private Set<Facture>factures;



}
