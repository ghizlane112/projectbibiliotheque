package org.example.projectbibiliotheque.web;


import org.example.projectbibiliotheque.entities.User;
import org.example.projectbibiliotheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class CompteController {

    @Autowired
    private UserService userService;

    @GetMapping("/listComptes")
    public String listComptes(Model model) {
        List<User> user = userService.findAllUsers();
        model.addAttribute("user", user);
        return "listComptes";
    }



}
