package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Client;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
