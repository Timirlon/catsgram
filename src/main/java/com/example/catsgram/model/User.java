package com.example.catsgram.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;

    public User(String email, String nickname, LocalDate birthdate) {
        this.email = email;
        this.nickname = nickname;
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || o.getClass() == this.getClass()) return false;

        User user = (User) o;
        return this.getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return this.getEmail().hashCode();
    }
}
