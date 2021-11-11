package tn.esprit.spring.services;

import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Stock;

import java.util.List;

public interface IServiceDetailProduit {
    List<DetailProduit> retrieveAllDetailProduits();

    DetailProduit addDetailProduit(DetailProduit detailProduit);

    DetailProduit retrieveDetailProduit(Long id);
    DetailProduit updateDetailProduit(DetailProduit u);
}
