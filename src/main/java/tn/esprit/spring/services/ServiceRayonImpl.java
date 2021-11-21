package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.repository.RayonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRayonImpl implements IServiceRayon{
    @Autowired
    RayonRepository repository;

    @Override
    public Rayon retrieveRayon(long idRayon) {
        return repository.findById(idRayon).orElse(null);
    }

    @Override
    public List<Rayon> retrieveAllRayons() {
        List<Rayon> rayons=new ArrayList<Rayon>();
        repository.findAll().forEach(rayon -> {
            rayons.add(rayon);
        });
        return rayons;
    }

    @Override
    public Rayon addrayon(Rayon r) {
        return repository.save(r);
    }

    @Override
    public Rayon upadateRayon(Rayon u) {
        return repository.save(u);
    }

    @Override
    public void deleteRayon(Long id) {
        repository.deleteById(id);
    }


}
