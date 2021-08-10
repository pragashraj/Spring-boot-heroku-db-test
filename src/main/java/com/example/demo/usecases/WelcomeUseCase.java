package com.example.demo.usecases;

import com.example.demo.repository.CustomerRepository;

public class WelcomeUseCase {
    private final CustomerRepository customerRepository;

    public WelcomeUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String execute() {
        return "Welcome";
    }
}
