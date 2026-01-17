package com.demo.springboottaskmanager.controller;

import com.demo.springboottaskmanager.dto.CreateOrderRequest;
import com.demo.springboottaskmanager.dto.OrderResponse;
import com.demo.springboottaskmanager.model.Order;
import com.demo.springboottaskmanager.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> getOrders() {
        return orderService.findAll();
    }

    @GetMapping("/customers/{customerId}/orders")
    public List<OrderResponse> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.findOrdersByCustomerId(customerId);
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }



}
