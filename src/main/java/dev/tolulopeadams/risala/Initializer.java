package dev.tolulopeadams.risala;

import dev.tolulopeadams.risala.persistence.dao.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Initializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public Initializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) {
        System.out.println("Initializing repositories");
        insertUsers(userRepository);
    }

    private void insertUsers(UserRepository repository) {
    }
}
