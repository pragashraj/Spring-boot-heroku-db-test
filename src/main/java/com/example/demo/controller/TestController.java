package com.example.demo.controller;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.usecases.WelcomeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test/")
public class TestController {
    private final CustomerRepository customerRepository;

    @Autowired
    public TestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("welcome")
    public String welcome() {
        try {
            WelcomeUseCase useCase = new WelcomeUseCase(customerRepository);
            return useCase.execute();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}