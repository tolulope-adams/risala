package dev.tolulopeadams.risala.repository;

import dev.tolulopeadams.risala.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserId(Long userId);
}