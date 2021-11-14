package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("produit")
    private DetailProduit detailProduit;
    public DetailProduit getDetailProduit() {
        return detailProduit;
    }
    public void setDetailProduit(DetailProduit detailProduit) {
        this.detailProduit = detailProduit;
    }
    @ManyToOne
    @JsonIgnoreProperties("produits")
    private Stock stock;
    @ManyToOne
    @JsonIgnoreProperties("produits") //pour eviter la dependance circulaire car on a une relation bidirectional
    private Rayon rayon;
    @ManyToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Fournisseur> fournisseurs=new ArrayList<Fournisseur>();
    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("produit")
    private List<DetailFacture> detailFactures=new ArrayList<DetailFacture>();

    public Produit(long idProduit) {
        this.idProduit = idProduit;
    }
}
