package dev.tolulopeadams.risala;

import dev.tolulopeadams.risala.model.User;
import dev.tolulopeadams.risala.model.repository.UserRepository;
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
        System.out.println("Initializing repositoreis");
        insertUsers(userRepository);
        System.out.println(userRepository.count());
    }

    private void insertUsers(UserRepository repository) {
        repository.save(new User("tolu"));

    }
}
