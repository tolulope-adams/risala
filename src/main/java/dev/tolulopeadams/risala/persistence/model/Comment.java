package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment extends Content {

//    @OneToMany(mappedBy = "reactionId", cascade = CascadeType.ALL)
//    private final List<Reaction> reactions = new ArrayList<>();
//
//    public Integer getReactionCount() {
//        return reactions.size();
//    }
//
//    public void addReaction(Reaction reaction) {
//        reactions.add(reaction);
//    }

}
