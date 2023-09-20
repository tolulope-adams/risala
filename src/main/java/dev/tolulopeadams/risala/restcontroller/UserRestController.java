package dev.tolulopeadams.risala.restcontroller;

import dev.tolulopeadams.risala.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest userRequest){
        User user = new User();

        user.setEmail("dummy_emal");
        user.setEmail("dummy_emal");

        return ResponseEntity.ok(user);
    }
}
