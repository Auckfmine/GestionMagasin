package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.*;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceProduitImp implements IServiceProduit{
    @Autowired
    ProduitRepository repository;
    @Autowired
    DetailProduitRepository rpRepository;
    @Autowired
    StockRepository sRepo;
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public List<Produit> retrieveAllProduits() {
        List<Produit>produits=new ArrayList<Produit>();
        repository.findAll().forEach(produit -> {
            produits.add(produit);
        });
        return produits;
    }

    @Override
    public Produit addProduit(Produit p ,long idRayon,Long idStock) {
            rpRepository.save(p.getDetailProduit());
            Stock s = new Stock();
            Rayon r = new Rayon();
            s=sRepo.findById(idStock).orElse(null);
            r=rayonRepository.findById(idRayon).orElse(null);
      /*  System.out.println("id Stock is : "+s.getIdStock());
        System.out.println("id rayon is : "+r.getIdRayon());*/
            p.setStock(s);
            p.setRayon(r);
            repository.save(p);

        return p;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = repository.findById(idProduit).orElse(null);
        Stock s = sRepo.findById(idStock).orElse(null);
        p.setStock(s);
        repository.save(p);
    }

    @Override
    public void assignFournisseurToProduit(long idFournisseur, long idProduit) {
        Fournisseur f = fournisseurRepository.findById(idFournisseur).orElse(null);
        Produit p = repository.findById(idProduit).orElse(null);
        p.getFournisseurs().add(f);
        repository.save(p);
    }


}
