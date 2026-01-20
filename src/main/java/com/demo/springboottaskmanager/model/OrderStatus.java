package com.demo.springboottaskmanager.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Order status")
public enum OrderStatus {
    NEW,
    PROCESSING,
    COMPLETED,
    CANCELLED
}

