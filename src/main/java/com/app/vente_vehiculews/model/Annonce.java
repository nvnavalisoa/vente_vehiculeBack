package com.app.vente_vehiculews.model;

import jakarta.persistence.Entity;

@Entity

public class Annonce extends  AnnonceSuperClass{

    public Annonce() {
    }

    public Annonce(Integer idannonce, int idutilisateur, String titre, String photo, boolean statusvente, boolean validation_annonce) {
        super(idannonce, idutilisateur, titre, photo, statusvente, validation_annonce);
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "idannonce=" + idannonce +
                ",idutilisateur=" + idutilisateur +
                ", titre='" + titre +
                ", descriptions='" + descriptions +
                ", idcategorie=" + idcategorie +
                ", idmarque=" + idmarque +
                ", idmodele=" + idmodele +
                ", prix=" + prix +
                ", photo=" + photo +
                '}';
    }
}
