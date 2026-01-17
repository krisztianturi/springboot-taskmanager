package com.demo.springboottaskmanager.service;

import com.demo.springboottaskmanager.model.Customer;
import com.demo.springboottaskmanager.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer c) {
        return customerRepository.save(c);
    }
}

