package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    private Post post;

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
