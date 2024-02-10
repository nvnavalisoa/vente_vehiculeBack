package com.app.vente_vehiculews.controller;

import com.app.vente_vehiculews.model.Annonce;
import com.app.vente_vehiculews.model.AnnonceDetails;
import com.app.vente_vehiculews.repository.AnnonceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceRepository annonceRepo;

    public AnnonceController(AnnonceRepository annonceRepo) {
        this.annonceRepo = annonceRepo;
    }

    @GetMapping
    List<AnnonceDetails> listAnnonceFront(){
        return annonceRepo.listAnnonceFront(true);
    }

    @GetMapping("/{idannonce}")
    public
    AnnonceDetails detailsAnnnonce(@PathVariable("idannonce") int idannonce){
        return annonceRepo.detailsAnnonce(idannonce);
    }

    //stocker une annonce
    @PostMapping
    public Annonce storeAnnonce(@RequestBody Annonce a){
        return annonceRepo.save(a);
    }


}
