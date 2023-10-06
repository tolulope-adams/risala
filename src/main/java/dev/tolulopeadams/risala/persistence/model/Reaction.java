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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "user_id", unique = true, nullable = false)
    protected Long userId;

    @ManyToOne
    @JoinColumn(name = "content_id", unique = true, nullable = false)
    protected Content content;
}
