package org.example.projectbibiliotheque.service;

import org.example.projectbibiliotheque.entities.Ressource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface RessourceService {





    Page<Ressource> getRessources(int pg);
    List<Ressource>  getAllRessource();
   Ressource getRessource(Long id);
   Ressource getRessource(String titre);
  Ressource addRessource(Ressource ressource);

    void editRessource(Long idres, Ressource updatedRessource1);

    void deleteRessource(Long idres);

  Ressource deleteRessource(String titre);
    void savePdfData(Long idRessource, byte[] pdfData);

   void telechargerRessource(Long idRessource);

    List<Ressource> findByNameContaining(String term);
   void updateRessource(Ressource ressource);

    void saveImage(MultipartFile image) throws Exception;

}
