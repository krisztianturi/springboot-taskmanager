package com.demo.springboottaskmanager.dto;

import java.time.LocalDate;

public record CreateOrderRequest(LocalDate orderDate,
                                 String status,
                                 String product,
                                 int quantity,
                                 Long customerId) {
}
