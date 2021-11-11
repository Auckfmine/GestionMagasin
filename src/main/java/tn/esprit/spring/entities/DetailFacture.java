package tn.esprit.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class DetailFacture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailFacture;
    private int qte;
    private float prixTotal;
    private int pourcentageRemise;
    private int montantRemise;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Facture facture;
}
