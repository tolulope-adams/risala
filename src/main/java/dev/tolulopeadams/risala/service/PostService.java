package dev.tolulopeadams.risala.service;

import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.persistence.model.Post;

import java.util.List;

public interface PostService {

    Post createPost(PostDto postDto);

    Post readPost(Long postId);

    void updatePost(Long postId, PostDto postDto);

    void deletePost(Long postId);

    List<Post> getAllPosts();
}
