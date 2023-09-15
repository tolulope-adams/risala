package dev.tolulopeadams.risala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/signup")
    public String signUp() {
//        User user = new User("John Doe", "john@example.com"); // Replace with your user data
//        model.addAttribute("user", user);
        return "index"; // Return the template name without the .html extension
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }
}
