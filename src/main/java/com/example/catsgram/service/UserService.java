package com.example.catsgram.service;

import com.example.catsgram.exceptions.InvalidEmailException;
import com.example.catsgram.exceptions.UserAlreadyExistsException;
import com.example.catsgram.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public Collection<User> findAll() {
        return users.values();
    }

    public User findUserByEmail(String email) {
        return users.get(email);
    }

    public List<User> findUsersByBirthdate(LocalDate birthdate) {
        return users.values()
                .stream()
                .filter(user -> user.getBirthdate().equals(birthdate))
                .toList();
    }

    public User create(User user) {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        }

        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        users.put(user.getEmail(), user);
        return user;
    }

    public User put(User user) {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        }

        users.put(user.getEmail(), user);
        return user;
    }
}
