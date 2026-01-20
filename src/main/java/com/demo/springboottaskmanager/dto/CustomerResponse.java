package com.demo.springboottaskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Customer response")
public record CustomerResponse(
        @Schema(description = "Customer unique identifier", example = "42")
        Long id,

        @Schema(description = "Full name of the customer")
        String name,

        @Schema(description = "Email address of the customer")
        String email
) {}



