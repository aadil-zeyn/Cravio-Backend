package com.capstone.cart.service;

import com.capstone.cart.Exception.CartnotFoundException;
import com.capstone.cart.model.Cart;
import com.capstone.cart.model.Orders;
import com.capstone.cart.repository.CartRepository;
import com.capstone.cart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KitchenStaffService {
    @Autowired
    private OrderRepository cartRepository;

    /**
     * Retrieves all orders.
     *
     * @return the list of all Cart objects
     */
    public List<Orders> getAllOrders() {
        return cartRepository.findAll();
    }

    /**
     * Updates the status of an order by cartId.
     *
     * @param cartId the cartId of the order to update
     * @param cart   the updated Cart object
     * @return the updated Cart object
     * @throws CartnotFoundException if the order with the specified cartId is not found
     */
    public Object updateStatus(Long cartId) throws CartnotFoundException {
        Orders c = cartRepository.findById(cartId).orElse(null);
        if (c != null) {
            c.setStatus("Ready");
            cartRepository.save(c);
        } else {
            throw new CartnotFoundException("No orders yet");
        }
        return c;
    }

    /**
     * Retrieves all orders by restaurant name.
     *
     * @param restName the name of the restaurant
     * @return the list of Cart objects for the specified restaurant name
     */
    public List<Orders> getAllOrdersbyRestuarentname(String restName) {
        return cartRepository.findAllByRestName(restName);
    }

    public List<Orders> getAllOrdersbyUsername(String username) {
        return cartRepository.findAllByUsername(username);
    }
}
