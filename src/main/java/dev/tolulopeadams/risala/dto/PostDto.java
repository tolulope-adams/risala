package dev.tolulopeadams.risala.dto;

import dev.tolulopeadams.risala.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private User user;

    private String content;
}
