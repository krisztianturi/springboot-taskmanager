package com.demo.springboottaskmanager.service;

import com.demo.springboottaskmanager.dto.CreateOrderRequest;
import com.demo.springboottaskmanager.dto.OrderResponse;
import com.demo.springboottaskmanager.model.Customer;
import com.demo.springboottaskmanager.model.Order;
import com.demo.springboottaskmanager.repository.CustomerRepository;
import com.demo.springboottaskmanager.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public Page<OrderResponse> findAll(Pageable pageable) {
        Page<Order> orders = orderRepository.findAll(pageable);
        return orders.map(order -> listToDto(order));
    }

    public Page<OrderResponse> findOrdersByCustomerId(Long customerId, Pageable pageable) {
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Customer not found");
        }
        Page<Order> orders = orderRepository.findByCustomerId(customerId, pageable);
        return orders.map(order -> listToDto(order));
    }


    private OrderResponse listToDto(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getOrderDate(),
                order.getStatus(),
                order.getProduct(),
                order.getQuantity(),
                order.getCustomer().getId(),
                order.getCustomer().getName()
        );
    }

    public OrderResponse createOrder(CreateOrderRequest request) {

        Customer customer = customerRepository
                .findById(request.customerId())
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));


        Order order = new Order( request.orderDate(), request.status(), request.product(), request.quantity(), customer);

        Order savedOrder = orderRepository.save(order);
        return new OrderResponse(savedOrder.getId(),savedOrder.getOrderDate(),savedOrder.getStatus(), savedOrder.getProduct(),savedOrder.getQuantity(), savedOrder.getId(), savedOrder.getCustomer().getName());
    }
}
