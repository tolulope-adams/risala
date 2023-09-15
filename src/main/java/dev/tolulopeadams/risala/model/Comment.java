package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comment_id", nullable=false, unique=true)
    private int commentId;
    @Column(name="post_id", nullable=false, unique=true)
    private int postId;
    @Column(name="author_id", nullable=false, unique=true)
    private int authorId;
    @Column(name="content", nullable=false)
    private String content;
    @Column(name="date_created", nullable=false)
    private String dateCreated;
    @Column(name="likes")
    private ArrayList<Integer> likes = new ArrayList<>();

    public Comment(){

    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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
}
