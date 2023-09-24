package dev.tolulopeadams.risala.web.controller;

import dev.tolulopeadams.risala.persistence.dao.UserRepository;
import dev.tolulopeadams.risala.persistence.model.User;
import dev.tolulopeadams.risala.requestbody.UserRequestBody;
import dev.tolulopeadams.risala.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/welcome")
    public String welcome() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/user/registration")
    public String registerUser(@RequestBody UserRequestBody requestBody){
        User user = userRepository.findByEmail(requestBody.getEmail());

        if(user != null){
//            ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("An account with that email address already exists");
            return "welcome";
        }

        userServiceImpl.registerUser(requestBody.getEmail(), requestBody.getPassword());
//        return ResponseEntity.ok("User registration successful").;
        return "welcome";

    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping("/@{username}")
//    public ModelAndView findByUserName(@PathVariable String username, ModelMap model){
//        User user = userRepository.findByUserNameIgnoreCase(username);
//        model.addAttribute("user", user);
//        return new ModelAndView("user-profile", model);
//    }
}
