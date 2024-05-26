package org.example.projectbibiliotheque.repositories;

import org.apache.tomcat.util.file.ConfigurationSource;
import org.example.projectbibiliotheque.entities.Category;
import org.example.projectbibiliotheque.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RessourceRepository  extends JpaRepository<Ressource,Long> {

   public Ressource findRessourceById(Long id);
   public Ressource findRessourceByTitre(String titre);
   public int checkAndUpdateBookAvailability(Long id);
   public void Delete(Long i);
    List<Ressource> findBookByCategory(Category category);



}
