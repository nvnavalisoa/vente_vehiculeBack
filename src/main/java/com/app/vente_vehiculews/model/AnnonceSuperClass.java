package com.app.vente_vehiculews.model;

import jakarta.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AnnonceSuperClass {
    @Id
    @Column(name = "idannonce")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_annonce")
    @SequenceGenerator(name = "pk_annonce",sequenceName = "s_idannonce",allocationSize = 1)
    Integer idannonce;

    @Column(name = "idutilisateur")
    int idutilisateur;

    @Column(name = "titre")
    String titre;

    @Column(name = "descriptions")
    String descriptions;

    @Column(name = "idcategorie")
    int idcategorie;
    @Column(name = "idmarque")
    int idmarque;
    @Column(name = "idmodele")
    int idmodele;

    @Column(name = "prix")
    double prix;

    @Column(name = "photo")
    String photo;

    public AnnonceSuperClass(Integer idannonce, int idutilisateur, String titre, String photo, boolean statusvente, boolean validation_annonce) {
    }

    public Integer getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(Integer idannonce) {
        this.idannonce = idannonce;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public int getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }

    public int getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public AnnonceSuperClass() {
    }


}
