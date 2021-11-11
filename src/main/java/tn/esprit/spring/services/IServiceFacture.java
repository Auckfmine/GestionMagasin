package tn.esprit.spring.services;

import tn.esprit.spring.entities.Facture;

import java.util.List;

public interface IServiceFacture {
    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
}
