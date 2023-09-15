package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", nullable=false, unique=true)
    private Long userId;
    @Column(name="user_name", nullable=false)
    private String userName;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="pass_hash", nullable=false)
    private String passwordHash;
    @Column(name="pass_salt", nullable=false, unique=true)
    private String passwordSalt;

    public User(){

    }

    public User(String email, String passwordHash, String passwordSalt){
        this.email = email;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + this.userId + ";" +
                "userName=" + this.userName + ";" +
                "}";
    }
}
