package com.example.catsgram.model;

import lombok.*;

import java.time.Instant;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@RequiredArgsConstructor
@Data //includes all 5 annotations above
public class Post {
    private int id;
    private final String author; // автор
    private final Instant creationDate = Instant.now(); // дата создания
    private String description; // описание
    @ToString.Exclude
    private String photoUrl; // url-адрес фотографии

    public Post(String author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}

