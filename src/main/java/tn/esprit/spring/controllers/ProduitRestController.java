package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.IServiceProduit;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {
@Autowired
    IServiceProduit serviceProduit;

//localhost:8089/SpringMVC/produit/add-produit
@PostMapping("/add-produit/{rayon_id}/{stock_id}/")
@ResponseBody
public Produit addProduit(@RequestBody Produit p, @PathVariable("rayon_id") long idRayon,@PathVariable("stock_id") long idStock ){
    Produit produit =new Produit();



        produit=serviceProduit.addProduit(p,idRayon,idStock);


    return produit;
}

    //localhost:8089/SpringMVC/produit/retrieve-all-produits/
    @GetMapping("/retrieve-all-produits/")
    @ResponseBody
    public List<Produit> getProduits(){

        return serviceProduit.retrieveAllProduits();
    }



    //localhost:8089/SpringMVC/produit/retrieve-all-produits/
    @GetMapping("/assign-fournisseur-to-Produit/{id_fournisseur}/{id_produit}/")
    @ResponseBody
    public void assignFournisseurToProduit(@PathVariable("id_fournisseur")long idFournisseur,@PathVariable("id_produit")long idProduit){

        serviceProduit.assignFournisseurToProduit(idFournisseur,idProduit);

    }



}
