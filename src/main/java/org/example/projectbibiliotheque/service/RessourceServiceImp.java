package org.example.projectbibiliotheque.service;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RessourceServiceImp implements RessourceService {
@Autowired
RessourceRepository ressourceRepository;

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

    }


    @Override
    public Ressource deleteRessource(String titre) {
    return  ressourceRepository.deleteByTitre(titre);
    }

    @Override
    public Ressource getRessourceById(Long id) {
        return null;
    }

    @Override
    public void telechargerRessource(Long idRessource) {

    }

    @Override
    public void updateRessource(Ressource ressource) {

    }

    @Override
    public void saveRessource(Ressource existingRessource) {

    }


}
