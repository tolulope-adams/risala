package dev.tolulopeadams.risala.web.controller;

import dev.tolulopeadams.risala.dto.PostDto;
import dev.tolulopeadams.risala.persistence.model.Post;
import dev.tolulopeadams.risala.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostServiceImpl postServiceImpl;

    @GetMapping("/feed")
    public String feed(Model model) {
        List<Post> postList = postServiceImpl.getAllPosts();
        model.addAttribute("postList", postList);
        return "feed";
    }

    @PostMapping("/post/create")
    public String createPost(@ModelAttribute PostDto postDto) {
        postServiceImpl.createPost(postDto);
        return "redirect:/feed";
    }

    @GetMapping("/posts/{id}")
    public String findPostById(@PathVariable Long id, Model model) {
        Post post = postServiceImpl.findPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("post/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute PostDto postDto) {
        postServiceImpl.updatePost(id, postDto);
        return "redirect:/feed";
    }

    @GetMapping("posts/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postServiceImpl.deletePost(id);
        return "redirect:/feed";
    }
}
