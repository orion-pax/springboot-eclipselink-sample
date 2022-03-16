package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RequestMapping("/users")
@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public String create(@RequestBody User user) {
        userRepository.save(user);
        return "User saved successfully";
    }

    @GetMapping("/")
    public Collection<User> list() {
        return userRepository.findAll();
    }
}
