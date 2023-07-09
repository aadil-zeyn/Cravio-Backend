package com.capstone.cart.service;

import com.capstone.cart.model.Cart;
import com.capstone.cart.model.Orders;
import com.capstone.cart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(Cart cNew) {
        Orders order=new Orders(cNew);
        orderRepository.save(order);
    }

    public void addOrders(List<Cart> orders) {
        for( Cart cart:orders){
            Orders order=new Orders(cart);
        orderRepository.save(order);}
    }
}
