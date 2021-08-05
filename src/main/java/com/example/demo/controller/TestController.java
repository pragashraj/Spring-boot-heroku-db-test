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

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("welcome")
    public String welcome() {
        return "Hello there";
    }

    @RequestMapping("get")
    public String getUser() {
        User user = userRepository.getById((long) 1);
        System.out.println(user);
        return "username: " + userRepository.getById((long) 1);
    }
}