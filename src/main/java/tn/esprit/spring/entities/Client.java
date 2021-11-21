package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table
@Getter
@Setter
@ToString

@RequiredArgsConstructor


public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long IdClient;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)

    private CategoryClient categoryClient;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Profession profession;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @ApiModelProperty(hidden = true)
    private List<Facture> factures= new ArrayList<Facture>();

    public List<Facture> getFactures() {
        return factures;
    }


    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }


}
