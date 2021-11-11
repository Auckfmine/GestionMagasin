package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.DetailProduit;

public interface DetailProduitRepository extends CrudRepository<DetailProduit,Long> {
}
