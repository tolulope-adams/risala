package dev.tolulopeadams.risala.service.impl;

import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.persistence.dao.PostRepository;
import dev.tolulopeadams.risala.persistence.model.Post;
import dev.tolulopeadams.risala.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setUser(postDto.getUser());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        postRepository.save(post);
        return post;
    }

    @Override
    public Post findPostById(Long id) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    @Override
    public void deletePost(Long id) {

    }

    @Override
    public void updatePost(Long id, PostDto postDto) {

    }
}
