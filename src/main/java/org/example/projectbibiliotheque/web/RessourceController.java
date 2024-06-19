package org.example.projectbibiliotheque.web;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.service.RessourceService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RessourceController {
RessourceService ressourceService;

  public RessourceController(RessourceService ressourceService){this.ressourceService=ressourceService;}
    @GetMapping("/ressources")
    Page<Ressource> getRessources(){
        return ressourceService.getRessources(1);
    }

    @GetMapping("/ressource/{id}")
    Ressource getRessource(@PathVariable Long id){
        return ressourceService.getRessource(id);
    }

    @GetMapping("/ressource/titre/{titre}")
    Ressource getRessource(@PathVariable String titre){
        return ressourceService.getRessource(titre);
    }

    @PostMapping("/ressource")
    Ressource addRessource(@RequestBody Ressource ressource){
        return ressourceService.addRessource(ressource);
    }


    @PutMapping("/ressource")
    void editRessource(@RequestParam Ressource updatedRessource1 ,
                               @RequestParam Long id){
        ressourceService.editRessource(id,updatedRessource1);
    }
    @DeleteMapping("/ressource/{id}")
    void deleteRessource(@PathVariable Long id){
        ressourceService.deleteRessource(id);
    }


    @DeleteMapping("/ressource/{titre}")
    Ressource deleteRessource(@PathVariable String titre){
        return ressourceService.deleteRessource(titre);
    }

    @PostMapping("/image")
    public boolean addImage(@RequestParam("file") MultipartFile image) {

        try {
            ressourceService.saveImage(image);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
        return true;
    }










}
