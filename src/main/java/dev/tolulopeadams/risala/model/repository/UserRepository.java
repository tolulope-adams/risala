package dev.tolulopeadams.risala.model.repository;

import dev.tolulopeadams.risala.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}