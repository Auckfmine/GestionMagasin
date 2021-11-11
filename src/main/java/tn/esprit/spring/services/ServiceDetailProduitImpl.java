package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.repository.DetailProduitRepository;

import java.util.List;
@Service

public class ServiceDetailProduitImpl implements IServiceDetailProduit{
    @Autowired
    DetailProduitRepository repository;

    @Override
    public List<DetailProduit> retrieveAllDetailProduits() {
        return null;
    }

    @Override
    public DetailProduit addDetailProduit(DetailProduit detailProduit) {
        return repository.save(detailProduit);
    }

    @Override
    public DetailProduit retrieveDetailProduit(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DetailProduit updateDetailProduit(DetailProduit u) {
        return repository.save(u);
    }
}
