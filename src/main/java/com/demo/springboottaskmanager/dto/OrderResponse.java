package com.demo.springboottaskmanager.dto;

import com.demo.springboottaskmanager.model.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
@Schema(description = "Order response")
public record OrderResponse(
        @Schema(description = "Order unique identifier", example = "42")
        Long id,

        @Schema(description = "Date of the order", example = "2026-01-16")
        LocalDate orderDate,

        @Schema(description = "Status of the order", example = "NEW")
        OrderStatus status,

        @Schema(description = "Product name")
        String product,

        @Schema(description = "Order quantity")
        int quantity,

        @Schema(description = "Customer unique identifier", example = "42")
        Long customerId,

        @Schema(description = "Full name of the customer")
        String customerName) {
}
