package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repository.FactureRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceFactureImpl implements IServiceFacture{
    @Autowired
    FactureRepository repository;
    @Override
    public List<Facture> retrieveAllFactures() {
        List<Facture>factures=new ArrayList<Facture>();
        repository.findAll().forEach(facture -> {
            factures.add(facture);
        });
        return factures;
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture =repository.findById(id).orElse(null);

        if(facture !=null){
            facture.setActive(false);
            repository.save(facture);
        }


    }

    @Override
    public Facture retrieveFacture(Long id) {
        return repository.findById(id).orElse(null);
    }
}
