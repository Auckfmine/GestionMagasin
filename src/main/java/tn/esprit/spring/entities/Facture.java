package tn.esprit.spring.entities;

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
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFacture;
    private float montantRemise ;
    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    private Boolean active;
    @OneToMany(mappedBy = "facture")
    private Set<DetailFacture>detailFactures;
    @ManyToOne
    private Client client;
}
