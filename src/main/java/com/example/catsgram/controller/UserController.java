package com.example.catsgram.controller;

import com.example.catsgram.model.User;
import com.example.catsgram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User put(@RequestBody User user) {
        return userService.put(user);
    }

    @GetMapping("/{userEmail}")
    public User findByEmail(@PathVariable String userEmail) {
        return userService.findUserByEmail(userEmail);
    }
}
