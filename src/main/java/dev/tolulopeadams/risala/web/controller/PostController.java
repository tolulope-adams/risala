package dev.tolulopeadams.risala.web.controller;

import dev.tolulopeadams.risala.persistence.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class PostController {

    @Autowired
    private BlogPostService blogPostService;  // Assume you have a service for managing blog posts

    @GetMapping("/feed")
    public String listPosts(Model model) {
        List<Post> blogPosts = blogPostService.getAllPosts();
        model.addAttribute("posts", blogPosts);
        return "post/list";
    }

    @GetMapping("/post")
    public String createPostForm(Model model) {
        model.addAttribute("post", new BlogPost());
        return "post/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute BlogPost post) {
        blogPostService.createPost(post);
        return "redirect:/blog/list";
    }

    @GetMapping("/{userName}/{postId}")
    public String readPost(@PathVariable String userName,
                           @PathVariable String postId, Model model) {
        Post post = null;
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute BlogPost post) {
        blogPostService.updatePost(post);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return "redirect:/blog/list";
    }
}
