package com.example.catsgram.controller;

import com.example.catsgram.model.User;
import com.example.catsgram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Collection<User> findAll(@RequestParam(required = false) LocalDate birthdate) {
        if (birthdate == null) {
            return userService.findAll();
        }

        return userService.findUsersByBirthdate(birthdate);
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
