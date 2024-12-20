package com.example.catsgram.utils;

import com.example.catsgram.model.Post;

import java.util.Comparator;

public class PostComparator implements Comparator<Post> {
    @Override
    public int compare(Post post1, Post post2) {
        if (post1.getCreationDate().isBefore(post2.getCreationDate())) {
            return 1;
        } else if (post2.getCreationDate().isBefore(post1.getCreationDate())) {
            return -1;
        } else {
            return 0;
        }
    }
}
