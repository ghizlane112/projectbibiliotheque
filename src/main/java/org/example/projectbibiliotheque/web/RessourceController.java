package org.example.projectbibiliotheque.web;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.service.RessourceService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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





    @PostMapping("/ressource/{id}/pdf")
    public ResponseEntity<String> uploadPdf(@PathVariable Long id,
                                            @RequestParam("pdfFile") MultipartFile pdfFile) {
        try {
            byte[] pdfBytes = pdfFile.getBytes();
            ressourceService.savePdfData(id, pdfBytes);
            return ResponseEntity.ok("PDF ajouté avec succès à la ressource.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du PDF à la ressource.");
        }
    }









}
