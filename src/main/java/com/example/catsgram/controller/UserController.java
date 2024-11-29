package com.example.catsgram.controller;

import com.example.catsgram.exceptions.InvalidEmailException;
import com.example.catsgram.exceptions.UserAlreadyExistsException;
import com.example.catsgram.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<Integer, User> users = new HashMap<>();

    @GetMapping
    public Map<Integer, User> findAll() {
        return users;
    }

    @PostMapping
    public User create(@RequestBody User user) throws InvalidEmailException, UserAlreadyExistsException {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        }

        if (users.containsKey(user.hashCode())) {
            throw new UserAlreadyExistsException();
        }

        users.put(user.hashCode(), user);
        return user;
    }

    @PutMapping
    public User put(@RequestBody User user) throws InvalidEmailException {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        }

        users.put(user.hashCode(), user);
        return user;
    }
}
