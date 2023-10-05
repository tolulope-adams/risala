package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", unique = true, nullable = false)  // Foreign key column
    private User user;

    @Column(name = "content")
    protected String content;

    @Column(name = "date_created")
    private String dateCreated;

//    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
//    private final List<Like> likes = new ArrayList<>();

    @Column(name = "likes_count")
    protected Long likesCount = 0L;

    @Column(name = "comments_count")
    protected Long commentsCount = 0L;

    public void incrementLikesCount() {
        ++likesCount;
    }

    public void incrementCommentsCount() {
        ++commentsCount;
    }
}
