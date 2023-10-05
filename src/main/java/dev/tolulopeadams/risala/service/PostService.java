package dev.tolulopeadams.risala.service;

import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.persistence.model.Post;

import java.util.List;

public interface PostService {

    Post findPostById(Long id);

    List<Post> getAllPosts();

    Post createPost(PostDto postDto);

    void updatePost(Long id, PostDto postDto);

    void deletePost(Long id);
}
