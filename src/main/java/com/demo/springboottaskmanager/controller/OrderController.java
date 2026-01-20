package com.demo.springboottaskmanager.controller;

import com.demo.springboottaskmanager.dto.CreateOrderRequest;
import com.demo.springboottaskmanager.dto.OrderResponse;
import com.demo.springboottaskmanager.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Orders", description = "Order management API")
@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "List all orders", description = "Returns all orders stored in the system")
    @GetMapping
    public Page<OrderResponse> getOrders(@ParameterObject Pageable pageable) {
        return orderService.findAll(pageable);
    }

    @Operation(summary = "List a customer's orders", description = "Returns all orders from a specified customer.")
    @GetMapping("/customers/{customerId}/orders")
    public Page<OrderResponse> getOrdersByCustomer(@PathVariable Long customerId, @ParameterObject Pageable pageable) {
        return orderService.findOrdersByCustomerId(customerId, pageable);
    }

    @Operation(summary = "Create new order", description = "Creates an order for an existing customer")
    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
}
