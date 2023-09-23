package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;

//@Entity
public class Like {
    private Long likeId;

    private Long userId;


    public Like(){

    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
