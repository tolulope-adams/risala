package dev.tolulopeadams.risala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/home")
    public String home() {
        return "index"; // Return the template name without the .html extension
    }
}
