package dev.tolulopeadams.risala.model.repository;

import dev.tolulopeadams.risala.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameIgnoreCase(@NonNull String userName);

}