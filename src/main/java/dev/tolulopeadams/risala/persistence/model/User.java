package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", nullable=false, unique=true)
    private Long userId;

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_name", unique = true)
    private String userName;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="pass_hash", nullable=false)
    private String passwordHash;
    @Column(name="pass_salt", nullable=false, unique=true)
    private String passwordSalt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Post> posts;

    public User(){
        posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void removePost(Post post) {
        this.posts.remove(post);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + this.getUserId() + ";" +
                "userName=" + this.getUserName() + ";" +
                "}";
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
}
