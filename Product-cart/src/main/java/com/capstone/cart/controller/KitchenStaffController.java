package com.capstone.cart.controller;

import com.capstone.cart.Exception.CartnotFoundException;
import com.capstone.cart.model.Cart;
import com.capstone.cart.repository.CartRepository;
import com.capstone.cart.service.KitchenStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@CrossOrigin("http://localhost:4200")
public class KitchenStaffController {
    @Autowired
    private KitchenStaffService service;

    //to retrive all orders
    @GetMapping("/orders")
    public ResponseEntity<List<Cart>> getAllOrders(){
        return ResponseEntity.ok(service.getAllOrders());
    }

    //get item by res
    @GetMapping("/ordersbyrestuarent/{restName}")
    public ResponseEntity<List<Cart>> getAllOrdersbyRestuarentname(@PathVariable String restName){
        return ResponseEntity.ok(service.getAllOrdersbyRestuarentname(restName));
    }

    @GetMapping("/ordersbyusername/{username}")
    public ResponseEntity<List<Cart>> getAllOrdersbyUsername(@PathVariable String username){
        return ResponseEntity.ok(service.getAllOrdersbyUsername(username));
    }

    @PutMapping("/orders/{cartId}")
    public ResponseEntity<?> updateStatus(@PathVariable Long cartId) throws CartnotFoundException {
        return ResponseEntity.ok(service.updateStatus(cartId));
    }
}
