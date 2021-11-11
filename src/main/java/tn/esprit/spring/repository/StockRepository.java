package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Stock;

public interface StockRepository extends CrudRepository<Stock,Long> {
}
