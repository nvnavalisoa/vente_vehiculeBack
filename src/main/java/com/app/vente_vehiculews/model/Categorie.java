package com.app.vente_vehiculews.model;

import jakarta.persistence.*;

@Entity
public class Categorie {
    @Id
    @Column(name = "idcategorie")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_categorie")
    @SequenceGenerator(name = "pk_categorie",sequenceName = "s_idcategorie",allocationSize = 1)
    Integer idcategorie;
    @Column
    private String nom;

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "idcategorie=" + idcategorie +
                ", nom=" + nom + '\'' +
                '}';
    }
}
