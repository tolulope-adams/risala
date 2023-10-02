package dev.tolulopeadams.risala.service.impl;

import dev.tolulopeadams.risala.dto.UserDto;
import dev.tolulopeadams.risala.persistence.dao.UserRepository;
import dev.tolulopeadams.risala.persistence.model.User;
import dev.tolulopeadams.risala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void registerUser(UserDto userDto){
        User user = this.createUser(userDto.getEmail(), userDto.getPassword());
        this.save(user);
    }

    @Override
    public User findUserByEmail(@NonNull String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPasswordSalt(this.generateSalt());
        user.setPasswordHash(this.encodePassword(
                password, user.getPasswordSalt(), bCryptPasswordEncoder)
        );
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void changeUserPassword(User user, String password) {

    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Arrays.toString(salt);
    }

    public String encodePassword(String password, String salt, PasswordEncoder passwordEncoder) {
        return passwordEncoder.encode(password + salt);
    }
}
