package com.demo.springboottaskmanager.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record CreateOrderRequest(@NotNull
                                 LocalDate orderDate,
                                 @NotBlank(message = "Status is required")
                                 String status,
                                 @NotBlank(message = "Product is required")
                                 String product,
                                 @PositiveOrZero(message = "Valid quantity is required")
                                 int quantity,
                                 @PositiveOrZero(message = "Valid customerId is required")
                                 Long customerId) {
}
