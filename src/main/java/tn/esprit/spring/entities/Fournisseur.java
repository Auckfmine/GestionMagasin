package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFournisseur;
    private String codeFournisseur;
    private String libelleFournisseur;
}
