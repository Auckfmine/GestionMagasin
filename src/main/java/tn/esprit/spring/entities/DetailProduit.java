package tn.esprit.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table
public class DetailProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailProduit;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Temporal(TemporalType.DATE)
    private  Date dateDerniereModification;
    @Enumerated(EnumType.STRING)
    private CategoryProduit categoryProduit;
    @OneToOne(mappedBy = "detailProduit")
    private Produit produit;
}
