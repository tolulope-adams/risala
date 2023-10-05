package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
