package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.repository.ProduitRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceProduitImp implements IServiceProduit{
    @Autowired
    ProduitRepository repository;

    @Override
    public List<Produit> retrieveAllProduits() {
        List<Produit>produits=new ArrayList<Produit>();
        repository.findAll().forEach(produit -> {
            produits.add(produit);
        });
        return produits;
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {

        return null;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return repository.findById(id).orElse(null);
    }
}
