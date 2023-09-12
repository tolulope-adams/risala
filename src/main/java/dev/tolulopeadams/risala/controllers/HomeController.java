package dev.tolulopeadams.risala.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
//        User user = new User("John Doe", "john@example.com"); // Replace with your user data
//        model.addAttribute("user", user);
        return "index"; // Return the template name without the .html extension
    }
}
