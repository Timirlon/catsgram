package com.example.catsgram.controller;

import com.example.catsgram.exceptions.InvalidEmailException;
import com.example.catsgram.exceptions.UserAlreadyExistsException;
import com.example.catsgram.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<String, User> users = new HashMap<>();

    @GetMapping
    public Collection<User> findAll() {
        return users.values();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        }

        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping
    public User put(@RequestBody User user) {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        }

        users.put(user.getEmail(), user);
        return user;
    }
}
