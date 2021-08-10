package com.example.demo.controller;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.request.CreateNewCustomerRequest;
import com.example.demo.usecases.CreateCustomerUseCase;
import com.example.demo.usecases.WelcomeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CreateNewCustomerRequest request) {
        try {
            CreateCustomerUseCase useCase = new CreateCustomerUseCase(customerRepository, request);
            return ResponseEntity.ok(useCase.execute());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}