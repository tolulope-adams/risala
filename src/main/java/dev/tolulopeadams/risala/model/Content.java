package dev.tolulopeadams.risala.model;

import jakarta.persistence.*;

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

    public Content(){

    }
}
