package tn.esprit.spring.services;

import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.entities.Stock;

import java.util.List;

public interface IServiceRayon {

    public Rayon retrieveRayon(long idRayon);

    List<Rayon> retrieveAllRayons();

    Rayon addrayon(Rayon r);

    Rayon upadateRayon(Rayon u);
    void deleteRayon(Long id);





}
