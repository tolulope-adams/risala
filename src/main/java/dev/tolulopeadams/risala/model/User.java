package dev.tolulopeadams.risala.model;

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
    @Column(name="user_name", nullable=false)
    private String userName;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="pass_hash", nullable=false)
    private String passwordHash;
    @Column(name="pass_salt", nullable=false, unique=true)
    private String passwordSalt;

    @OneToMany(mappedBy = "postId",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    public User(){

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
                "userId=" + this.userId + ";" +
                "userName=" + this.userName + ";" +
                "}";
    }
}
