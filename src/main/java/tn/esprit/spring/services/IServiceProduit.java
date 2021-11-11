package tn.esprit.spring.services;

import tn.esprit.spring.entities.Produit;

import java.util.List;

public interface IServiceProduit {
    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Produit retrieveProduit(Long id);
}
