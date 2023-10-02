package dev.tolulopeadams.risala.persistence.dao;

import dev.tolulopeadams.risala.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(@NonNull String email);

}