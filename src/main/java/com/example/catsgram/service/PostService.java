package com.example.catsgram.service;

import com.example.catsgram.exceptions.UserNotFoundException;
import com.example.catsgram.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserService userService;
    private final List<Post> posts = new ArrayList<>();
    private int idCounter = 1;

    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        String email = post.getAuthor();
        if (userService.findUserByEmail(email) == null) {
            throw new UserNotFoundException("Пользователь " + email + " не найден.");
        }

        int postId = idCounter++;
        post.setId(postId);

        posts.add(post);

        return post;
    }

    public Post findById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow();
    }
}
