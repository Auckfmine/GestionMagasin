package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
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
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStock;
    private int qteStock;
    private int qteMin;
    private String libelleStock;
    @OneToMany(mappedBy = "stock")

    @JsonIgnoreProperties("stock")
    @ApiModelProperty(hidden = true)
    private List<Produit> produits=new ArrayList<Produit>();
}
