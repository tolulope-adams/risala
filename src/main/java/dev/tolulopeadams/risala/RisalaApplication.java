package dev.tolulopeadams.risala;

import dev.tolulopeadams.risala.model.User;
import dev.tolulopeadams.risala.model.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class RisalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RisalaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository repository){
		return args -> {
			insertUsers(repository);
		};
	}

	private void insertUsers(UserRepository repository) {
//		repository.save(new User("Dalia", "Tolu", "Tobi"));
//		repository.save(new User("Dali", "Tol", "Tob"));
	}
}
