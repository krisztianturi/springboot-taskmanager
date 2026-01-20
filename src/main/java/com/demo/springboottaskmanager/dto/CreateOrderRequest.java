package com.demo.springboottaskmanager.dto;
import com.demo.springboottaskmanager.model.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
@Schema(description = "Order creation request")
public record CreateOrderRequest(@Schema(example = "2026-01-16")
                                 @NotNull
                                 LocalDate orderDate,

                                 @Schema(example = "NEW")
                                 @NotNull(message = "Status is required")
                                 OrderStatus status,

                                 @Schema(example = "Laptop")
                                 @NotBlank(message = "Product is required")
                                 String product,

                                 @Schema(example = "2")
                                 @PositiveOrZero(message = "Valid quantity is required")
                                 int quantity,

                                 @Schema(example = "7")
                                 @PositiveOrZero(message = "Valid customerId is required")
                                 Long customerId) {
}
