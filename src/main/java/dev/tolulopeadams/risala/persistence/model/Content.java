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

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
    private final List<Reaction> reactions = new ArrayList<>();

    public Integer getReactionCount() {
        return reactions.size();
    }

    public void addReaction(Reaction reaction) {
        reactions.add(reaction);
    }
}
