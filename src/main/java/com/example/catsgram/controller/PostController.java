package com.example.catsgram.controller;

import com.example.catsgram.exceptions.IncorrectParameterException;
import com.example.catsgram.model.Post;
import com.example.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<Post> findAll(@RequestParam(required = false, defaultValue = "desc") String sort,
                              @RequestParam(required = false, defaultValue = "10") int size,
                              @RequestParam(required = false, defaultValue = "0") int page) {

        if (!sort.equals("asc") && !sort.equals("desc")) {
            throw new IncorrectParameterException("sort");
        }

        if (size < 0) {
            throw new IncorrectParameterException("size");
        }

        if (page < 0) {
            throw new IncorrectParameterException("page");
        }

        List<Post> posts = postService.findAll(sort, size, page);

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
