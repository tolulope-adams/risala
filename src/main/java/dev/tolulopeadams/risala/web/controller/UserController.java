package dev.tolulopeadams.risala.web.controller;

import dev.tolulopeadams.risala.persistence.model.User;
import dev.tolulopeadams.risala.persistence.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository userRepository;

    @GetMapping("/@{username}")
    public ModelAndView findByUserName(@PathVariable String username, ModelMap model){
        User user = userRepository.findByUserNameIgnoreCase(username);
        model.addAttribute("user", user);
        return new ModelAndView("user-profile", model);
    }


}
