package dev.tolulopeadams.risala.model;

import dev.tolulopeadams.risala.model.Like;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="content_id", nullable = false, unique = true)
    private Long contentId;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="author_id", nullable=false, unique=true)
    private Long authorId;

    @Column(name="date_created", nullable=false)
    private String dateCreated;

    @OneToMany(mappedBy = "likeId",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private final ArrayList<Like> likes;


    public Content(){
       this.likes = new ArrayList<>();
    }


    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void addLike(Like like) {
        this.likes.add(like);
    }

    public void removeLike(Like like) {
        this.likes.remove(like);
    }
}
