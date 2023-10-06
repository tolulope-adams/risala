package dev.tolulopeadams.risala.web.controller;

import dev.tolulopeadams.risala.dto.UserDto;
import dev.tolulopeadams.risala.persistence.model.Post;
import dev.tolulopeadams.risala.persistence.model.User;
import dev.tolulopeadams.risala.service.impl.PostServiceImpl;
import dev.tolulopeadams.risala.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/signup")
    public String signup(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "signup";
    }

    @PostMapping("/user/register")
    public String registerUser(@Valid @ModelAttribute UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existing = userServiceImpl.findUserByEmail(userDto.getEmail());

        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("userDto", existing);
            return "redirect:/signup";
        }
        userServiceImpl.registerUser(userDto);
        return "redirect:/feed";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    public static String getHttpUrl(HttpServletRequest request, String endpoint) {
        String baseUrl = "http://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath();
        return baseUrl + endpoint;
    }
}
