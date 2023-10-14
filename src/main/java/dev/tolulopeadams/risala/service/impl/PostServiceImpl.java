package dev.tolulopeadams.risala.service.impl;

import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.persistence.dao.PostRepository;
import dev.tolulopeadams.risala.persistence.model.Post;
import dev.tolulopeadams.risala.persistence.model.Reaction;
import dev.tolulopeadams.risala.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Post readPost(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            //TODO: Throw Post Not Found Exception
            return null;
        }
    }


    @Override
    public void updatePost(Long postId, PostDto postDto) {
        
    }


    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void addReaction(Long postId, Long userId, Integer reactionType) {
        Post post = this.readPost(postId);
        post.addReaction(new Reaction(post, userId, reactionType));
        postRepository.save(post);
    }
}
