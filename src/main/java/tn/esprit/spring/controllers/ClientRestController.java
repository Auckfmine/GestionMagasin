package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.CategoryClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.services.IServiceClient;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRestController {
    @Autowired
    IServiceClient clientService;

    // http://localhost:8089/SpringMVC/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    @ResponseBody
    public List<Client> getClients() {
        List<Client> listClients = clientService.retrieveAllClients();
        return listClients;
    }


    // http://localhost:8089/SpringMVC/client/retrieve-client/8
    @GetMapping("/retrieve-client/{client-id}")
    @ResponseBody
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping("/add-client")
    @ResponseBody
    public Client addClient(@RequestBody Client c)
    {
        Client client = clientService.addClient(c);

        return client;
    }





    // http://localhost:8089/SpringMVC/client/remove-client/{client-id}
    @DeleteMapping("/remove-client/{client-id}")
    @ResponseBody
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.deleteClient(clientId);
    }

    // http://localhost:8089/SpringMVC/client/modify-client
    @PutMapping("/modify-client")
    @ResponseBody
    public Client modifyClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }


    // http://localhost:8089/SpringMVC/client/getChiffreAffaireParCategorieClient/{start_date}/{end_date}/
    @PostMapping("/getChiffreAffaireParCategorieClient/{start_date}/{end_date}/")
    @ResponseBody
    public float getChiffreAffaireParCategorieClient(@RequestBody CategoryClient categoryClient ,@PathVariable("start_date") Date startDate ,@PathVariable("end_date") Date endDate)
    {


        return clientService.getChiffreAffaireParCategorieClient(categoryClient, startDate, endDate);
    }


}
