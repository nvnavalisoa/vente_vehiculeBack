package com.app.vente_vehiculews.controller;

import com.app.vente_vehiculews.model.*;
import com.app.vente_vehiculews.repository.*;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    UtilisateurRepository utilisateurrepo;
    AnnonceRepository annonceRepository;
    CategorieRepository categorieRepository;
    MarqueRepository marqueRepository;
    ModeleRepository modeleRepository;
     AuthTokenRepository authtokenrepo;

     @Autowired
    public UtilisateurController(UtilisateurRepository utilisateurrepo, AnnonceRepository annonceRepository, CategorieRepository categorieRepository, MarqueRepository marqueRepository, ModeleRepository modeleRepository, AuthTokenRepository authtokenrepo) {
        this.utilisateurrepo = utilisateurrepo;
        this.annonceRepository = annonceRepository;
        this.categorieRepository = categorieRepository;
        this.marqueRepository = marqueRepository;
        this.modeleRepository = modeleRepository;
        this.authtokenrepo = authtokenrepo;
    }

    //inscription utilisateur
    @PostMapping
    public void inscription(@RequestBody Utilisateur u)throws SQLException {
         utilisateurrepo.save(u);
    }

    //login utilisateur
    @PostMapping("/checkLogin")
    public Object[] login(@RequestBody Map<String, Object> payload) throws NoResultException {
        Object[] tokenUser = new Object[2];
        String email = (String) payload.get("email");
        String mdp = (String) payload.get("mdp");
        List<Utilisateur> allUser = utilisateurrepo.findAll();
        System.out.println("Email et mdp "+email + mdp);

        for (Utilisateur user : allUser) {
            if (user.getEmail().equals(email) && user.getMdp().equals(mdp)) {
                //creation de token
                AuthToken token = new AuthToken();
                token.generateToken(email, mdp);
                //sauvegarde token database
                authtokenrepo.save(token);
                //tableau a retourner vers l'utilisateur

                System.out.println(token.getToken()+' '+user.getIdutilisateur());
                tokenUser[0] = token.getToken();
                tokenUser[1] = user.getIdutilisateur();
                System.out.println(tokenUser[0]);
                return tokenUser;
            }
        }
        throw new NoResultException("Non identifier");
    }

    //annonce utilisateur specifique
    @GetMapping("/{idutilisateur}/annonces")
    public List<AnnonceStatus> listMyAnnonce(@PathVariable("idutilisateur") int iduser){
        return annonceRepository.listAnnonceUtilisateur(iduser);
    }

    //update status annonce
    @PutMapping("/annonces/annonce/{idannonce}")
    public void updateStatus(@PathVariable("idannonce")int idannonce){
        annonceRepository.updateStatusAnnonce(true, idannonce);
    }


    @GetMapping("/categories")
    public List<Categorie> listCategorie(){
        return categorieRepository.findAll();
    }

    @GetMapping("/marques")
    public  List<Marque> listMarque(){
        return marqueRepository.findAll();
    }

    @GetMapping("modeles")
    public List<Modele> listModele(){
        return  modeleRepository.findAll();
    }


}
