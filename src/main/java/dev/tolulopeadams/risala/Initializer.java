package dev.tolulopeadams.risala;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.dto.UserDto;
import dev.tolulopeadams.risala.service.impl.PostServiceImpl;
import dev.tolulopeadams.risala.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
class Initializer implements CommandLineRunner {

    // Added comment here
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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

    private void createPosts() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/json/dummy_post_one.json");
            if (inputStream != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode postNode = objectMapper.readTree(inputStream);
                LOGGER.info("Parsed JSON as JsonNode: ");

                PostDto postDto = new PostDto();
                postDto.setUser(userServiceImpl.findUserByEmail("tolulopeadams700@gmail.com"));
                postDto.setTitle(postNode.get("title").asText());
                postDto.setContent(postNode.get("content").asText());
                postServiceImpl.createPost(postDto);
            } else {
                LOGGER.error("File not found.");
            }
        } catch (IOException e) {
            LOGGER.error("Error reading file: " + e.getMessage());
        }
    }
}
