package com.demo.springboottaskmanager.service;

import com.demo.springboottaskmanager.dto.CreateOrderRequest;
import com.demo.springboottaskmanager.model.Customer;
import com.demo.springboottaskmanager.model.Order;
import com.demo.springboottaskmanager.repository.CustomerRepository;
import com.demo.springboottaskmanager.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Order createOrder(CreateOrderRequest request) {

        Customer customer = customerRepository
                .findById(request.customerId())
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        Order order = new Order(
                null,
                request.orderDate(),
                request.status(),
                request.product(),
                request.quantity(),
                customer
        );

        return orderRepository.save(order);
    }
}
