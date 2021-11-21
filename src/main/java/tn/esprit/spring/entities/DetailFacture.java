package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class DetailFacture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailFacture;
    private int qte;
    private float prixTotal;
    private int pourcentageRemise;
    private int montantRemise;
    @ManyToOne
    @JsonIgnoreProperties("detailFactures")
    private Produit produit;
    @ManyToOne
    private Facture facture;
}
