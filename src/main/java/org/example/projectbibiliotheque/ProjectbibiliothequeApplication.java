package org.example.projectbibiliotheque;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProjectbibiliothequeApplication  implements CommandLineRunner {
    @Autowired
   RessourceRepository ressourceRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProjectbibiliothequeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        //Insertion des produits

        //Nombre d'enregistrement dans "Product"
     /*   System.out.println(" ------ Nombre total des ressource: "
                +ressourceRepository.count()+"------");

        //Lecture de la table "Product"
        Iterable<Ressource> ressources =ressourceRepository.findAll();
        for (Ressource p:ressources) {
            System.out.println(p.getIdRessource()+" - "+ p.getTitre() + " - " +p.getDatePublication());
        }

*/

    }
}
