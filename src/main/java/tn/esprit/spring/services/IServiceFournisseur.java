package tn.esprit.spring.services;



import tn.esprit.spring.entities.Fournisseur;

import java.util.List;

public interface IServiceFournisseur {
    List<Fournisseur> retreiveAllFournisseurs();
    Fournisseur addFournisseur(Fournisseur f);
    void deleteFournisseur(Long id);
    Fournisseur updateFournisseur(Fournisseur c);
    Fournisseur retriveFournisseur(Long id);
}
