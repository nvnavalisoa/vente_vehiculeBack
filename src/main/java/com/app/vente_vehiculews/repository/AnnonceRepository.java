package com.app.vente_vehiculews.repository;

import com.app.vente_vehiculews.model.Annonce;
import com.app.vente_vehiculews.model.AnnonceDetails;
import com.app.vente_vehiculews.model.AnnonceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
    @Query(value = "select * from v_detailsannonce where validation_annonce=:validation", nativeQuery = true)
    List<AnnonceDetails> listAnnonceFront(@Param("validation") boolean validation);

    @Query(name = "listAnnonceUtilisateur", nativeQuery = true)
    List<AnnonceStatus> listAnnonceUtilisateur(@Param("idutilisateur") int idUtilisateur);

    @Query(name = "detailsAnnonce", nativeQuery = true)
    AnnonceDetails detailsAnnonce(@Param("idannonce") int idannonce);

    //modifier le status d'une annonce
    @Transactional
    @Modifying
    @Query(value = "update annonce set statusvente=?1 where idannonce=?2", nativeQuery = true)
    public void updateStatusAnnonce(boolean status, int idannonce);

    //Validation d'une annonce
    @Transactional
    @Modifying
    @Query(value = "update annonce set validation_annonce=?1 where idannonce=?2", nativeQuery = true)
    public void updateValidationAnnonce(boolean validation, int idannonce);
}
