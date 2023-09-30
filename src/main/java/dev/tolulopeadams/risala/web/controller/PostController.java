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

@Controller
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/post/create")
    public String createPost(@ModelAttribute PostDto postDto){
        postService.createPost(postDto);
        return "redirect:/feed";
    }

    @GetMapping("/posts/{id}")
    public String findPostById(@PathVariable Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("post/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute PostDto postDto) {
        postService.updatePost(id, postDto);
        return "redirect:/feed";
    }

    @GetMapping("posts/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/feed";
    }
}
