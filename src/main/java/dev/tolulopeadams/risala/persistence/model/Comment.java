package dev.tolulopeadams.risala.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment extends Content {

}
