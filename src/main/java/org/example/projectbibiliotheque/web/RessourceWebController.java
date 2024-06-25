package org.example.projectbibiliotheque.web;

import org.example.projectbibiliotheque.entities.Ressource;
import org.example.projectbibiliotheque.repositories.RessourceRepository;
import org.example.projectbibiliotheque.service.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RessourceWebController {

    RessourceService ressourceService;
    RessourceRepository ressourceRepository;

@Autowired
public RessourceWebController(RessourceService ressourceService){
    this.ressourceService=ressourceService;
}


    @GetMapping("/index")
    String getRessource(Model model,
                       @RequestParam(defaultValue = "0") int page) {
        Page<Ressource> RessourceList = ressourceService.getRessources(page);
        model.addAttribute("ressource", RessourceList);
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






    @GetMapping("/addRessource")
    public String addRessource() {
        return "addRessource"; // Assuming excitingPrograms.html is your new exciting programs template
    }


    @GetMapping("/search")
    public String search(@RequestParam("term") String term, Model model) {
        List<Ressource> ressources = ressourceService.findByNameContaining(term);
        int occurence = ressources.size();
        model.addAttribute("ressources", ressources);
        model.addAttribute("occurence", occurence);
        return "listRessource";  // return the view that displays the search results
    }








}
