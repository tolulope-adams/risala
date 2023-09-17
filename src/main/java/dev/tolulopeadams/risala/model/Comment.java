package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Comment extends Content{
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "like_id")
    private final List<Like> likes;


    public Comment(){
        this.likes = new ArrayList<>();

    }
    public Post getPost() {
        return post;
    }

    public List<Like> getLikes() {
        return likes;
    }

}
