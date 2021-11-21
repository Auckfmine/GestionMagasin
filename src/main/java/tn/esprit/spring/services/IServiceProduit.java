package tn.esprit.spring.services;

import tn.esprit.spring.entities.Produit;

import java.util.Date;
import java.util.List;

public interface IServiceProduit {
    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p,long idRayon, Long idStock);

    Produit retrieveProduit(Long id);
//Service Avancée
    void assignProduitToStock(Long idProduit, Long idStock);
    void assignFournisseurToProduit(long idFournisseur ,long idProduit);
    float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
