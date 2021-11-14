package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.repository.RayonRepository;

@Service
public class ServiceRayonImpl implements IServiceRayon{
    @Autowired
    RayonRepository repository;

    @Override
    public Rayon retrieveRayon(long idRayon) {
        return repository.findById(idRayon).orElse(null);
    }
}
