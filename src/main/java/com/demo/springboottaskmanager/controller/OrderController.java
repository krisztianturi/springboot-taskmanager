package com.demo.springboottaskmanager.controller;

import com.demo.springboottaskmanager.dto.CreateOrderRequest;
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
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    @GetMapping("/customers/{customerId}/orders")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.findOrdersByCustomerId(customerId);
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }



}
