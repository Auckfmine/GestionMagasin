package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.services.IServiceFournisseur;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class FourinsseurRestController {

    @Autowired
    IServiceFournisseur serviceFournisseur;


    //localhost:8089/fournisseur/add-fournisseur
    @PostMapping("/add-fournisseur")
    @ResponseBody

    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
       return serviceFournisseur.addFournisseur(fournisseur);
    }

    //localhost:8089/fournisseur/retrieve-fournisseur/{id_fournisseur}
    @GetMapping("/retrive-fournisseur/{id_fourisseur}")
    @ResponseBody
    public Fournisseur retirieveFournisseur(@PathVariable("id_fournisseur")Long idFournisseur){
        return serviceFournisseur.retriveFournisseur(idFournisseur);
    }

    //localhost:8089/fournisseur/update-fournisseur
    @PutMapping("/update-fournisseur")
    @ResponseBody

    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur){
       return serviceFournisseur.updateFournisseur(fournisseur);
    }

    //localhost:8089/fournissuer/delete-fournisseur/{id_fournisseur}
    @DeleteMapping("/delete-fournissuer/{id_fournisseur}")
    @ResponseBody
    public void deleteFournisseur(@PathVariable("id_fournisseur")Long idFournissuer){
        serviceFournisseur.deleteFournisseur(idFournissuer);
    }


    //localhost:8089/fournisseur/retrieve-all-fournisseurs
    @GetMapping("/retrieve-all-fournisseurs")
    @ResponseBody

    public List<Fournisseur> retriveAllFournissuers(){
        return serviceFournisseur.retreiveAllFournisseurs();
    }
}
