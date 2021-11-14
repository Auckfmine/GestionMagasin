package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.CategoryClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repository.ClientRepository;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public float getChiffreAffaireParCategorieClient(CategoryClient categorieClient, Date startDate, Date endDate) {
        float chiffre_affaire = 0;
        List<Facture> factures =repository.getClientsByCategory(categorieClient);
        for(Facture facture : factures){
            if(facture.getDateFacture().compareTo(startDate)>0 && facture.getDateFacture().compareTo(endDate)<0){
                chiffre_affaire+=facture.getMontantFacture();
            }
        }


        return chiffre_affaire;
    }
}
