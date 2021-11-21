package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.ProduitRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceFactureImpl implements IServiceFacture{
    @Autowired
    FactureRepository repository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DetailFactureRepository detailFactureRepository;
    @Autowired
    ProduitRepository produitRepository;


    @Override
    public List<Facture> retrieveAllFactures() {
        List<Facture>factures=new ArrayList<Facture>();
        repository.findAll().forEach(facture -> {
            factures.add(facture);
        });
        return factures;
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture =repository.findById(id).orElse(null);

        if(facture !=null){
            facture.setActive(false);
            repository.save(facture);
        }


    }

    @Override
    public Facture retrieveFacture(Long id) {
        return repository.findById(id).orElse(null);
    }


    //Services Avancés :

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {


        List<Facture> factures = new ArrayList<Facture>();    //retrieve client

        Client c = clientRepository.findById(idClient).orElse(null); //retrieve factures from clients
        c.getFactures().forEach(facture -> {            // remplir une liste avec les factures de clients
            factures.add(facture);
        });

        return factures;            //retourner la liste


        //2éme Solution tout simplement on utilise le JPQL
        /*
        * SELECT f from Facture f where f.client=:client
        *
        * List<Facture> getFacturesByClient(@param('client') Client client)
        *
        * */
    }


            //Service Avancé Add Facture
    @Override
    public Facture addFacture(Facture f, Long idClient) {
        Client c = clientRepository.findById(idClient).orElse(null);
        f.setClient(c);

        float prixTotal = 0;
        int pourcentageRemise =0;
        int montantRemise = 0;


        for(DetailFacture detailFacture :f.getDetailFactures()){
            // recherche du produit de chaque detailFacture
           // System.out.println(detailFacture.getProduit().getIdProduit());
           Produit p =  produitRepository.findById(detailFacture.getProduit().getIdProduit()).orElse(null);
           detailFacture.setProduit(p);

            //remplissage de detail factures avec les prix des produits associé
            int qte = detailFacture.getQte();
            float dfPrixTotal =detailFacture.getProduit().getPrixUnitaire() * qte ;
             int pourcentageRemiseDf = detailFacture.getPourcentageRemise();
             int montantRemiseDf = (int)prixTotal*pourcentageRemise/100;

             //pour le calcul du somme des Prix et remise pour chaque detail Facture pour laffichage dans la facture finale
             prixTotal+=dfPrixTotal;
             pourcentageRemise+=pourcentageRemiseDf;
             montantRemise+=montantRemiseDf;

            detailFacture.setPrixTotal(dfPrixTotal);
            detailFacture.setPourcentageRemise(pourcentageRemiseDf);
            detailFacture.setMontantRemise(montantRemiseDf);
            detailFactureRepository.save(detailFacture);
        }


        //remplissage de la facture avec la somme des prix des detailFactures
        f.setMontantRemise(montantRemise);
        f.setMontantFacture(prixTotal);
        f.setActive(true);
        repository.save(f);
        return f;
    }
}
