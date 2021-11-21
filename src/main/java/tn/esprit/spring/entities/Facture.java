package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @OneToMany(mappedBy = "facture",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("facture")
    @ApiModelProperty(hidden = true)
    private List<DetailFacture> detailFactures=new ArrayList<DetailFacture>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("factures")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
