package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.services.IServiceRayon;

@RestController
@RequestMapping("/rayon")
public class RayonRestController {

    @Autowired
    IServiceRayon serviceRayon;

    //localhost:8089/rayon/addRayon
    @PostMapping("/addRayon")
    @ResponseBody
    public Rayon addRayon(@RequestBody Rayon r){
        return serviceRayon.addrayon(r);
    }

    //localhost:8089:/rayon/retrieve-rayon/{id_rayon}
    @GetMapping("/retrive-rayon/{id_rayon}")
    @ResponseBody

    public Rayon retiriveRayon(@PathVariable("id_rayon")Long idRayon){
        return serviceRayon.retrieveRayon(idRayon);
    }

    //localhost:8089/rayon/update-rayon/
    @PutMapping("/update-rayon/")
    @ResponseBody

    public Rayon updateRayon(@RequestBody Rayon rayon){
        return serviceRayon.upadateRayon(rayon);
    }


    //localhost:8089/rayon/delete-rayon/{id_rayon}
    @DeleteMapping("/delete-rayon/{id_rayon}")
    @ResponseBody

    public void deleteRayon(@PathVariable("id_rayon")Long idRayon){
        serviceRayon.deleteRayon(idRayon);
    }
}
