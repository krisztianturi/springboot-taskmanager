package com.demo.springboottaskmanager.dto;

import java.time.LocalDate;

public record OrderResponse(Long id,
                            LocalDate orderDate,
                            String status,
                            String product,
                            int quantity,
                            Long customerId,
                            String customerName) {
}
