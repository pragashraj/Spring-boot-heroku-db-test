package com.example.demo.usecases;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.request.CreateNewCustomerRequest;

public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;
    private final CreateNewCustomerRequest request;

    public CreateCustomerUseCase(CustomerRepository customerRepository, CreateNewCustomerRequest request) {
        this.customerRepository = customerRepository;
        this.request = request;
    }

    public Customer execute() {
        Customer customer = Customer
                .builder()
                .name(request.getName())
                .build();
        customerRepository.save(customer);
        return customer;
    }
}
