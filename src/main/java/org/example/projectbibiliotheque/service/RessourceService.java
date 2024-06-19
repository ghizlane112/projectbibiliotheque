package org.example.projectbibiliotheque.service;

import org.example.projectbibiliotheque.entities.Ressource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RessourceService {

    Page<Ressource> getRessources(int pg);
   Ressource getRessource(Long id);
   Ressource getRessource(String titre);
  Ressource addRessource(Ressource ressource);

    void editRessource(Long idres, Ressource updatedRessource1);

    void deleteRessource(Long idres);

  Ressource deleteRessource(String titre);
   Ressource getRessourceById(Long id);
   void telechargerRessource(Long idRessource);


   void updateRessource(Ressource ressource);

    void saveImage(MultipartFile image) throws Exception;

}
