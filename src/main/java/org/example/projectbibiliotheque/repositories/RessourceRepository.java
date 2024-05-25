package org.example.projectbibiliotheque.repositories;

import org.apache.tomcat.util.file.ConfigurationSource;
import org.example.projectbibiliotheque.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository  extends JpaRepository<Ressource,Long> {


}
