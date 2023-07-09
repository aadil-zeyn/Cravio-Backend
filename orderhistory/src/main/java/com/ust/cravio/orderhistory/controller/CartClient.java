package com.ust.cravio.orderhistory.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CART.KITCHENSTAFF-SERVICE")
public interface CartClient {
    String deleteCartbyUsername(@PathVariable String username);
}
