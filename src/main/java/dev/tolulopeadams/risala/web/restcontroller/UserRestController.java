package dev.tolulopeadams.risala.web.restcontroller;

import dev.tolulopeadams.risala.persistence.dao.UserRepository;
import dev.tolulopeadams.risala.persistence.model.User;
import dev.tolulopeadams.risala.requestbody.UserRequestBody;
import dev.tolulopeadams.risala.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;



}
