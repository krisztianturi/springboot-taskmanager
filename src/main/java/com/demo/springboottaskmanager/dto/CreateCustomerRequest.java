package com.demo.springboottaskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Schema(description = "Customer creation request")
public record CreateCustomerRequest(
        @Schema(description = "Customer full name", example = "Nagy Lajos")
        @NotBlank(message = "Name is required")
        String name,

        @Schema(description = "Customer email addres", example = "example@yahoo.com")
        @Email(message = "Email must be valid")
        @NotBlank(message = "Email is required")
        String email) {}
