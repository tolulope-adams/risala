package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "posts")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="post_id", nullable=false, unique=true)
    private int post_id;
    @Column(name="author_id", nullable=false, unique=true)
    private int author_id;
    @Column(name="content", nullable=false)
    private String content;
    @Column(name="date_created", nullable=false)
    private String dateCreated;
    @Column(name="likes")
    private ArrayList<Integer> likes = new ArrayList<>();
    @Column(name="comments")
    private ArrayList<Integer> comments = new ArrayList<>();

    public Post(){

    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ArrayList<Integer> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Integer> likes) {
        this.likes = likes;
    }

    public ArrayList<Integer> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Integer> comments) {
        this.comments = comments;
    }
}
