package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;


@Entity
public class Comment extends Content{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JoinColumn(name="comment_id", nullable=false, unique=true)
    private Long commentId;

    public Comment(){

    }

}
