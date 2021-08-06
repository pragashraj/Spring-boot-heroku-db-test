package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test/")
public class TestController {

    private final UserRepository userRepository;

    @Autowired
    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("welcome")
    public String welcome() {
        return "Hello there";
    }

    @RequestMapping("get")
    public String getUser() {
        try {
            User user = userRepository.findByName("admin");
            if (user == null)
                return "No user";
            return "username: " + user.getName();
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("create")
    public String create() {
        User user = new User("admin");
        userRepository.save(user);
        return "created";
    }
}