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
        if (posts.isEmpty()) {
            return posts;
        }

        if (sort.equals("desc")) {
            posts.sort(new PostComparator());
        } else if (sort.equals("asc")) {
            posts.sort(new PostComparator().reversed());
        }

        List<List<Post>> newPosts = new ArrayList<>();

        for (int i = 0; i < posts.size(); i += size) {
            List<Post> temp = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                try {
                    temp.add(posts.get(j + i));
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }

            newPosts.add(temp);
        }

        return newPosts.get(page);
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
