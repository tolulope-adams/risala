package dev.tolulopeadams.risala.service;

import dev.tolulopeadams.risala.persistence.model.User;
import org.springframework.lang.NonNull;

public interface UserService {
    User findUserByEmail(@NonNull String email);
    User createUser(String email, String password);
    void save(@NonNull User user);
    void changeUserPassword(@NonNull User user, @NonNull String password);
    void deleteUser(@NonNull User user);
}
