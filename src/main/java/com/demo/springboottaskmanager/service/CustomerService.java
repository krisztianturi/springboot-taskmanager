package com.demo.springboottaskmanager.service;

import com.demo.springboottaskmanager.dto.CreateCustomerRequest;
import com.demo.springboottaskmanager.dto.CustomerResponse;
import com.demo.springboottaskmanager.model.Customer;
import com.demo.springboottaskmanager.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Page<CustomerResponse> findAll(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.map(c -> new CustomerResponse(c.getId(),c.getName(),c.getEmail()));
    }

    public CustomerResponse save(CreateCustomerRequest request) {
        Customer savedCustomer = customerRepository.save(new Customer(request.name(),request.email()));
        return new CustomerResponse(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getEmail());
    }
}

