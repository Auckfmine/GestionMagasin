package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.services.IServiceFacture;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureRestController {
    @Autowired
    IServiceFacture serviceFacture;

    //localhost:8098/facture/retrieve-all-factures/
    @GetMapping("/retrieve-all-factures")
    @ResponseBody
    public List<Facture> getFactures() {
        List<Facture> listFactures = serviceFacture.retrieveAllFactures();
        return listFactures;
    }

    //localhost:8098/facture/cancel-facture/idFacture
    @GetMapping("/cancel-facture/{idFacture}")
    @ResponseBody
    public void cancelFacture(@PathVariable("idFacture") Long idFacture){
        serviceFacture.cancelFacture(idFacture);
    }

    //localhost:8098/facture/retrieve-facture
    @GetMapping("/retrieve-facture/{idFacture}")
    @ResponseBody
    public Facture retrieveFacture(@PathVariable("idFacture")Long idFacture){
        return serviceFacture.retrieveFacture(idFacture);
    }
}
