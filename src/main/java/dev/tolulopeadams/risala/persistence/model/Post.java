package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "posts")
@Entity
public class Post extends Content {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", unique = true)
    private User user;

////    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//    private final List<Comment> comments;
//
////    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "like_id")
//    private final List<Like> likes;

    public Post(){
//        this.comments = new ArrayList<>();
//        this.likes = new ArrayList<>();

    }
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void addComment(Comment comment) {
//        this.comments.add(comment);
//    }
//
//    public void removeComment(Comment comment) {
//        this.comments.remove(comment);
//    }
//
//    public List<Like> getLikes() {
//        return likes;
//    }
//
//    public void addLike(Like like) {
//        this.likes.add(like);
//    }
//
//    public void removeLike(Like like) {
//        this.likes.remove(like);
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
