package com.demo.springboottaskmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="ORDERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "ORDER_SEQ", allocationSize = 1)
    private Long id;

    private LocalDate orderDate;
    private String status;
    private String product;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
}