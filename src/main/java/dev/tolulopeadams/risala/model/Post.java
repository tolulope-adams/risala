package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "posts")
@Entity
public class Post extends Content {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JoinColumn(name="post_id", nullable=false, unique=true)
    private Long postId;

    @OneToMany(mappedBy = "commentId",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ArrayList<Comment> comments = new ArrayList<>();

    public Post(){

    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }
}
