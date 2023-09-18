package dev.tolulopeadams.risala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // Return the template name without the .html extension
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
