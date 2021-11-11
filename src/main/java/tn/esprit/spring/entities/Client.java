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
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdClient;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private CategoryClient categoryClient;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @OneToMany(mappedBy = "client")
    private Set<Facture>factures;



}
