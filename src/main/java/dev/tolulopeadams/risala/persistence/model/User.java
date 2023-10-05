package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_name", unique = true)
    private String userName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "pass_hash", nullable = false)
    private String passwordHash;
    @Column(name = "pass_salt", nullable = false, unique = true)
    private String passwordSalt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void removePost(Post post) {
        this.posts.remove(post);
    }

    @Override
    public String toString() {
        return "User {" +
                "userId=" + this.getUserId() + ";" +
                "userName=" + this.getUserName() + ";" +
                "}";
    }
}
