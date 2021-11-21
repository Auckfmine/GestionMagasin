package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceFournisseurImpl implements IServiceFournisseur{
    @Autowired
    FournisseurRepository repository;
    @Override
    public List<Fournisseur> retreiveAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        repository.findAll().forEach(fournisseur -> {
            fournisseurs.add(fournisseur);
        });
        return fournisseurs;
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        return repository.save(f);
    }

    @Override
    public void deleteFournisseur(Long id) {
            repository.deleteById(id);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur c) {
        return repository.save(c);
    }

    @Override
    public Fournisseur retriveFournisseur(Long id) {
        return repository.findById(id).orElse(null);
    }
}
