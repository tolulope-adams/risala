package dev.tolulopeadams.risala.service;

import dev.tolulopeadams.risala.persistence.model.User;

public interface UserService {
//
//    User findUserByEmail(String email);


   User createUser(String email, String password);

    void save(User user);

//    void changeUserPassword(User user, String password);
//
    void deleteUser(User user);

}
