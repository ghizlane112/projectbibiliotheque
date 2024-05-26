package org.example.projectbibiliotheque.service;

import org.example.projectbibiliotheque.entities.Ressource;

import java.util.List;

public interface RessourceService {


   Ressource getRessource(Long id);
   Ressource getRessource(String titre);
  Ressource addRessource(Ressource ressource);

    void editRessource(Long idres, Ressource updatedRessource1);

    void deleteRessource(Long idres);

  Ressource deleteRessource(String titre);
   Ressource getRessourceById(Long id);
   void telechargerRessource(Long idRessource);

   void updateRessource(Ressource ressource);
   void saveRessource(Ressource existingRessource);



}
