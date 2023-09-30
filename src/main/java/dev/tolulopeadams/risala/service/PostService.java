package dev.tolulopeadams.risala.service;

import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.persistence.model.Post;

public interface PostService {

    Post findPostById(Long id);
    Post createPost(PostDto postDto);
    void updatePost(Long id, PostDto postDto);
    void deletePost(Long id);
}
