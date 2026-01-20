package com.demo.springboottaskmanager.repository;

import com.demo.springboottaskmanager.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findAll(Pageable pageable);
    Page<Order> findByCustomerId(Long customerId, Pageable pageable);

}


