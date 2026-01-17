package com.demo.springboottaskmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
    @SequenceGenerator(name = "cust_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();


}

