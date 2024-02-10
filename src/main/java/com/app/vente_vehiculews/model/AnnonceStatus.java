package com.app.vente_vehiculews.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQuery;

@Entity

//liste des annonces d'un utilisateur+status
@NamedNativeQuery(
        name="listAnnonceUtilisateur",
        query="select * from v_detailsannonce where idutilisateur= :idutilisateur",
        resultClass = AnnonceStatus.class
)

public class AnnonceStatus extends Annonce{
    boolean statusvente;


    public boolean isStatusvente() {
        return statusvente;
    }

    public void setStatusvente(boolean statusvente) {
        this.statusvente = statusvente;
    }


    @Override
    public String toString() {
        return "AnnonceStatus{" +
                "idannonce=" + idannonce +
                ", idutilisateur=" + idutilisateur +
                ", titre='" + titre +
                ", descriptions='" + descriptions +
                ", idcategorie=" + idcategorie +
                ", idmarque=" + idmarque +
                ", idmodele=" + idmodele +
                ", prix=" + prix +
                ", photo=" + photo +
                ", statusvente=" + statusvente +
                '}';
    }
}
