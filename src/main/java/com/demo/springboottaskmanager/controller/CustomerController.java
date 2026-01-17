package com.demo.springboottaskmanager.controller;

import com.demo.springboottaskmanager.dto.CreateCustomerRequest;
import com.demo.springboottaskmanager.dto.CustomerResponse;
import com.demo.springboottaskmanager.model.Customer;
import com.demo.springboottaskmanager.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.save(request);
    }

}

