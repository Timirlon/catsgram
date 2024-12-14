package com.example.catsgram.controller;

import com.example.catsgram.model.Post;
import com.example.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<Post> findAll() {
        List<Post> posts = postService.findAll();

        log.debug("Текущее количество постов:{} ", posts.size());

        return posts;
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/{postId}")
    public Post findById(@PathVariable int postId) {
        return postService.findById(postId);
    }

}
