package dev.tolulopeadams.risala.controller;

import dev.tolulopeadams.risala.model.User;
import dev.tolulopeadams.risala.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/@{username}")
    public String findByUserName(@PathVariable String username, Model model){
        User user = userRepository.findByUserNameIgnoreCase(username);
        model.addAttribute("user", user);
        return "user-profile";
    }
}
