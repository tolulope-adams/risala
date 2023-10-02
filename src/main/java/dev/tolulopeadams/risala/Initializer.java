package dev.tolulopeadams.risala;

import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.dto.UserDto;
import dev.tolulopeadams.risala.service.impl.PostServiceImpl;
import dev.tolulopeadams.risala.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Initializer implements CommandLineRunner {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    PostServiceImpl postServiceImpl;

    public Initializer() {

    }

    @Override
    public void run(String... strings) {
        createUsers();
        createPosts();
    }

    private void createUsers() {
        System.out.println("Creating dummy users");
        userServiceImpl.registerUser(
                new UserDto("Tolulope Adams",
                        "tolulopeadams700@gmail.com",
                        "ris@l@2o23"));
    }

    private void createPosts(){
        PostDto postDto = new PostDto();
        postDto.setUser(userServiceImpl.findUserByEmail("tolulopeadams700@gmail.com"));
        postDto.setContent("Hi guys, welcome to my YouTube channel.");
        postServiceImpl.createPost(postDto);
    }
}
