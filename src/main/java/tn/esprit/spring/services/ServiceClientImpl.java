package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceClientImpl implements IServiceClient {
    @Autowired
    ClientRepository repository;
    @Override
    public List<Client> retrieveAllClients() {
        List<Client>clients=new ArrayList<Client>();
        repository.findAll().forEach(client -> {
            clients.add(client);
        });
        return clients;
    }

    @Override
    public Client addClient(Client c) {
        return repository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return repository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return repository.findById(id).orElse(null);
    }
}
