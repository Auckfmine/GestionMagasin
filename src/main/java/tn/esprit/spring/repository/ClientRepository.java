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


    @Query("SELECT  f   FROM Facture f where f.client.categoryClient =: categorieClient ")
    List <Facture> getFacturesByCategoryClient(@Param("categoryClient") CategoryClient categorieClient);
}
