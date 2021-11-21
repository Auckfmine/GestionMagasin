package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.entities.CategoryClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;

import java.util.Date;
import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long> {


    @Query("SELECT  c.factures   FROM Client c where c.categoryClient =: categorieClient ")
    List <Facture> getClientsByCategory(@Param("categoryClient") CategoryClient categorieClient);
}
