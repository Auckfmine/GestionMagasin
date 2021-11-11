package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Facture;

public interface FactureRepository extends CrudRepository<Facture,Long> {
}
