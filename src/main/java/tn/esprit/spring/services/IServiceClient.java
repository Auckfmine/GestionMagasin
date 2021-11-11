package tn.esprit.spring.services;

import tn.esprit.spring.entities.Client;

import java.util.List;

public interface IServiceClient {
    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
}
