package org.example.projectbibiliotheque.web;
import org.example.projectbibiliotheque.entities.User;
import org.example.projectbibiliotheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String registrationForm() {
        return "user";
    }


    @GetMapping("/listComptes")
    public String listComptes() {
        return "listComptes"; // Assuming excitingPrograms.html is your new exciting programs template
    }
}