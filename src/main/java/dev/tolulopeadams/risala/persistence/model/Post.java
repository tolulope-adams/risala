package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
@Entity
public class Post extends Content {

    @Column(name = "thumbnail")
    private String thumbNail;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
    private final List<Reaction> reactions = new ArrayList<>();

    public Integer getReactionCount() {
        return reactions.size();
    }

    public void addReaction(Reaction reaction) {
        reactions.add(reaction);
    }

}
