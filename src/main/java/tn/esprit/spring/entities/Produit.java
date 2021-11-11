package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prixUnitaire;
    @OneToOne
    private DetailProduit detailProduit;
    @ManyToOne
    private Stock stock;
    @ManyToOne
    private Rayon rayon;
    @ManyToMany
    private Set<Fournisseur>fournisseurs;
    @OneToMany(mappedBy = "produit")
    private Set<DetailFacture> detailFactures;

}
