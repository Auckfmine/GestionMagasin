package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Stock;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock,Long> {

@Query("SELECT s from Stock s where s.idStock< s.qteMin")
List<Stock> getStatusStock();
}
