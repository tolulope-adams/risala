package dev.tolulopeadams.risala.web.controller;

import dev.tolulopeadams.risala.dto.UserDto;
import dev.tolulopeadams.risala.persistence.dao.UserRepository;
import dev.tolulopeadams.risala.persistence.model.User;
import dev.tolulopeadams.risala.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String signup(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/user/registration")
    public ResponseEntity<?> userRegistration(HttpServletRequest servletRequest,
                                             @RequestBody UserDto userDto){
        User existing = userRepository.findByEmail(userDto.getEmail());

        userServiceImpl.registerUser(userDto);

        String redirectUrl = getAppUrl(servletRequest) + "/index";
        return ResponseEntity.ok().body("{\"redirectUrl\": \"" + redirectUrl + "\"}");
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() + ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
