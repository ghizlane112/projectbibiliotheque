package org.example.projectbibiliotheque.service;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RessourceServiceImp implements RessourceService {
@Autowired
RessourceRepository ressourceRepository;

    @Override
    public Page<Ressource> getRessources(int pg) {
        return ressourceRepository
                .findAll(PageRequest.of(pg,15));
    }

    @Override
    public List<Ressource> getAllRessource() {
        return ressourceRepository.findAll();
    }

    @Override
    public Ressource getRessource(Long id) {

        return ressourceRepository.findRessourceByIdRessource(id);
    }

    @Override
    public Ressource getRessource(String titre) {
      return ressourceRepository.findRessourceByTitre(titre);
    }

    @Override
    public Ressource addRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }



    @Override
    public void editRessource(Long idres, Ressource updatedRessource1) {
      Ressource ResToBeEdited = ressourceRepository.findRessourceByIdRessource(idres);
        if(ResToBeEdited!=null) {

          ResToBeEdited.setIdRessource(updatedRessource1.getIdRessource());
          ResToBeEdited.setTitre(updatedRessource1.getTitre());
          ResToBeEdited.setDatePublication(updatedRessource1.getDatePublication());
          ressourceRepository.save(ResToBeEdited);
        }

    }

    @Override
    public void deleteRessource(Long idres) {

    ressourceRepository.deleteById(idres);
    }


    @Override
    public Ressource deleteRessource(String titre) {
    return  ressourceRepository.deleteByTitre(titre);
    }

    @Override
    public void savePdfData(Long idRessource, byte[] pdfData) {

        Optional<Ressource> optionalRessource = ressourceRepository.findById(idRessource);
        if (optionalRessource.isPresent()) {
            Ressource ressource = optionalRessource.get();
            ressource.setPdfData(pdfData);
            ressourceRepository.save(ressource);
        } else {
            throw new RuntimeException("Ressource not found with id: " + idRessource);
        }



    }


    @Override
    public void telechargerRessource(Long idRessource) {

    }

    @Override
    public List<Ressource> findByNameContaining(String term) {
      return  ressourceRepository.findByTitreContaining(term);
    }

    @Override
    public void updateRessource(Ressource ressource) {
     ressourceRepository.save(ressource);
    }

    @Override
    public void saveImage(MultipartFile image) throws Exception {
        if (!image.isEmpty()) {
            try {
                // Créer un nouveau fichier avec un nom unique dans le répertoire de destination
                File destinationFile = new File("chemin/vers/le/repertoire/de/destination/" + image.getOriginalFilename());
                // Copier le contenu du fichier d'entrée dans le fichier de destination
                FileCopyUtils.copy(image.getInputStream(), new FileOutputStream(destinationFile));
            } catch (IOException e) {
                // Gérer l'exception si la copie échoue
                throw new IOException("Impossible de sauvegarder le fichier", e);
            }
        } else {
            // Gérer le cas où le fichier est vide
            throw new IOException("Le fichier est vide");
        }



    }


}
