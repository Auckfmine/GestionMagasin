package tn.esprit.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Rayon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRayon;
    private String codeRayon;
    private String libelleRayon;
    @OneToMany(mappedBy = "rayon")
    private Set<Produit>produits;
}
