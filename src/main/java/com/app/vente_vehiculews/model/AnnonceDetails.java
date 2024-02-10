package com.app.vente_vehiculews.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;

@Entity

@NamedNativeQuery(
        name = "detailsAnnonce",
        query = "select idannonce, idutilisateur, titre, descriptions, " +
                "idcategorie, idmarque, idmodele, prix, photo, " +
                "nom_categorie, nom_marque, nom_modele, validation_annonce from v_detailsannonce where idannonce=:idannonce",
        resultClass = AnnonceDetails.class
)

public class AnnonceDetails extends Annonce{

    @Column(name = "nom_categorie")
    String nom_categorie;
    @Column(name = "nom_marque")
    String nom_marque;
    @Column(name = "nom_modele")
    String nom_modele;

    boolean validation_annonce;

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getNom_marque() {
        return nom_marque;
    }

    public void setNom_marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }

    public String getNom_modele() {
        return nom_modele;
    }

    public void setNom_modele(String nom_modele) {
        this.nom_modele = nom_modele;
    }

    public boolean isValidation_annonce() {
        return validation_annonce;
    }

    public void setValidation_annonce(boolean validation_annonce) {
        this.validation_annonce = validation_annonce;
    }

    @Override
    public String toString() {
        return "AnnonceDetails{" +
                "idannonce=" + idannonce +
                ",idutilisateur=" + idutilisateur +
                ", titre=" + titre +
                ", descriptions=" + descriptions +
                ", idcategorie=" + idcategorie +
                ", idmarque=" + idmarque +
                ", idmodele=" + idmodele +
                ", prix=" + prix +
                ", photo=" + photo +
                ", nom_categorie=" + nom_categorie +
                ", nom_marque=" + nom_marque +
                ", nom_modele=" + nom_modele +
                ", validation_annonce=" + validation_annonce +
                '}';
    }
}
