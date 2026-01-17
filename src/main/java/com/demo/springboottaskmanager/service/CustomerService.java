package com.demo.springboottaskmanager.service;

import com.demo.springboottaskmanager.dto.CreateCustomerRequest;
import com.demo.springboottaskmanager.dto.CustomerResponse;
import com.demo.springboottaskmanager.model.Customer;
import com.demo.springboottaskmanager.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponse> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(c -> new CustomerResponse(
                        c.getId(),
                        c.getName(),
                        c.getEmail()
                ))
                .toList();
    }


    public CustomerResponse save(CreateCustomerRequest request) {
        Customer savedCustomer = customerRepository.save(new Customer(request.name(),request.email()));
        return new CustomerResponse(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getEmail());
    }
}

