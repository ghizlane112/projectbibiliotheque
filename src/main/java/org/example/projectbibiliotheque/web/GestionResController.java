package org.example.projectbibiliotheque.web;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.service.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GestionResController {
    @Autowired
    private final RessourceService ressourceService;


    public GestionResController(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @GetMapping("/listRessources")
    public String listRessources(Model model) {
        List<Ressource> ressources = ressourceService.getAllRessource();
        model.addAttribute("ressources", ressources);
        return "listRessource"; // C'est le nom de votre fichier HTML Thymeleaf (sans l'extension .html)
    }

    // Cette méthode gère l'affichage initial de la liste des ressources

    @PostMapping("/addRessource")
    public String addRessource(@ModelAttribute Ressource ressource) {
            ressourceService.addRessource(ressource);
            return "redirect:/listRessources";
        }


    @GetMapping("/deleteRessource")
    String deleteRessourceById(@RequestParam Long id) {
        System.out.println("RESSOURCE TO BE DELETE: " + id);
       ressourceService. deleteRessource(id);
        return "redirect:/listRessources";
    }







    }

