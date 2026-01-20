package com.demo.springboottaskmanager.controller;

import com.demo.springboottaskmanager.dto.CreateCustomerRequest;
import com.demo.springboottaskmanager.dto.CustomerResponse;
import com.demo.springboottaskmanager.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Customers", description = "Customer management API")
@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "List customers", description = "Returns a paginated list of all customers.")
    @GetMapping
    public Page<CustomerResponse> getCustomers(@ParameterObject Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @Operation(summary = "Create customer", description = "Creates a new customer in the system")
    @PostMapping
    public CustomerResponse addCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        return customerService.save(request);
    }
}