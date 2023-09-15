package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;

@Table(name = "likes")
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="like_id", nullable=false, unique=true)
    private int likeId;
    @Column(name="content_id", nullable=false, unique=true)
    private int contentId;
    @Column(name="user_id", nullable=false, unique=true)
    private int user_id;

    public Like(){

    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
