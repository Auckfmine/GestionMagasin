package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.DetailFacture;

public interface DetailFactureRepository extends CrudRepository<DetailFacture,Long> {
}
