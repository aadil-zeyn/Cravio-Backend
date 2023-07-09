package com.capstone.cart.repository;

import com.capstone.cart.model.Cart;
import com.capstone.cart.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findAllByRestName(String restName);

    List<Orders> findAllByUsername(String username);
}
