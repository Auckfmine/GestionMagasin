package tn.esprit.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStock;
    private int qteStock;
    private int qteMin;
    private String libelleStock;
    @OneToMany(mappedBy = "stock")
    private Set<Produit> produits;
}
