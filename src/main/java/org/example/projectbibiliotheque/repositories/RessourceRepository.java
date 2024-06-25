package org.example.projectbibiliotheque.repositories;

import org.example.projectbibiliotheque.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long> {



    List<Ressource> findAll();
    Ressource findRessourceByIdRessource(Long id);
    Ressource findRessourceByTitre(String titre);
   // int checkAndUpdateRessourceAvailability(Long id);

    List<Ressource> findByTitreContaining(String term);

    Ressource deleteByTitre(String name);


}
