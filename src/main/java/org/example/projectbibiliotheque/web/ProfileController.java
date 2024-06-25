package org.example.projectbibiliotheque.web;

import org.springframework.ui.Model;
import org.example.projectbibiliotheque.entities.User;
import org.example.projectbibiliotheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profil")
    public String userProfile(Model model, Principal principal) {
        String email = principal.getName(); // Obtient l'email de l'utilisateur connecté
        User user = userService.findUserByEmail(email);
        model.addAttribute("user", user);
        return "profil";
    }
}
