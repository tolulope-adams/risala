package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "reactions")
@Entity
public class Reaction {

    @Transient
    public static final Integer REACT_LIKE = 0;
    @Transient
    public static final Integer REACT_LOVE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "content_id", unique = true, nullable = false)
    protected Content content;

    @Column(name = "user_id", unique = true, nullable = false)
    protected Long userId;

    @Column(name = "content_id", unique = true, nullable = false)
    protected Integer reactionType;

    public Reaction(Content content, Long userId, Integer reactionType) {
        this.userId = userId;
        this.content = content;
        this.reactionType = reactionType;
    }
}
