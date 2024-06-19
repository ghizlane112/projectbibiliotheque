package org.example.projectbibiliotheque.web;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.service.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RessourceWebController {

    RessourceService ressourceService;

@Autowired
public RessourceWebController(RessourceService ressourceService){
    this.ressourceService=ressourceService;
}


    @GetMapping("/index")
    String getRessource(Model model,
                       @RequestParam(defaultValue = "0") int page) {
        Page<Ressource> RessourceList = ressourceService.getRessources(page);
        model.addAttribute("prdcts", RessourceList);
        model.addAttribute("title", "List of de ressource");
        model.addAttribute("count", RessourceList.getTotalElements());
        model.addAttribute("currentPage", RessourceList.getNumber());

        int[] listPages = new int[RessourceList.getTotalPages()];
        for (int i = 0; i < listPages.length; i++) listPages[i] = i;

        model.addAttribute("listPages", listPages);

        // Add a new Product object to the model
        model.addAttribute("ressource", new Ressource());

        return "ressources"; //Nom de la page HTML (templates)
    }










}
