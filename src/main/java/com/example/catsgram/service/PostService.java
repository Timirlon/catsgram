package com.example.catsgram.service;

import com.example.catsgram.exceptions.UserNotFoundException;
import com.example.catsgram.model.Post;
import com.example.catsgram.utils.PostComparator;
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

    public List<Post> findAll(String sort, int size, int page) {
        List<Post> sortedPosts = new ArrayList<>(posts);

        if (sort.equals("desc")) {
            sortedPosts.sort(new PostComparator());
        } else if (sort.equals("asc")) {
            sortedPosts.sort(new PostComparator().reversed());
        }

        int from = size * page;

        return sortedPosts.subList(from, Math.min(posts.size(), size));
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
