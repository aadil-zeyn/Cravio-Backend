package com.capstone.cart.controller;

import java.util.List;

import com.capstone.cart.model.Orders;
import com.capstone.cart.service.KitchenStaffService;
import com.capstone.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capstone.cart.model.Cart;
import com.capstone.cart.service.CartService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class  CartController {
	
	@Autowired
	CartService cartServ;

	//for orders creating seperate service class
	@Autowired
	private OrderService orderService;

	@Autowired
	private KitchenStaffService service;

	//retrieve item by cart id
	
	@GetMapping("cart/viewBycart/{cId}")
	public ResponseEntity<?> getDetailsByCartId(@PathVariable Long cId){
		Cart c = cartServ.getByCartId(cId);
		if(c!=null)
			return new ResponseEntity<Cart>(c, HttpStatus.OK);
		else
			return new ResponseEntity<String>("Cart not available",HttpStatus.NOT_FOUND);
	}

	//retrieve item by userid
	@GetMapping("cart/viewByuser/{username}")
	public ResponseEntity<?> getDetailsByUserName(@PathVariable String username){
		List<Cart> cList = cartServ.getByUserName(username);
		if(cList != null)
			return new ResponseEntity<List<Cart>>(cList, HttpStatus.OK);
		else
			return new ResponseEntity<String>("User not available",HttpStatus.NOT_FOUND);
		
	}
	//to add item into cart
	@PostMapping("cart/addCart")
	public ResponseEntity<?> addCart(@RequestBody Cart cNew){

		Cart c = cartServ.addCart(cNew);

//		orderService.addOrder(cNew);

		return new ResponseEntity<Cart>(c, HttpStatus.OK);
	}

	//to delete an item in cart
	
	
	//-------------------------
	@DeleteMapping("cart/del/{cartId}/{username}")
    public ResponseEntity<String> deleteCart(@PathVariable Long cartId, @PathVariable String username) {
		cartServ.deleteCartByCartIdAndUsername(cartId, username);
        return ResponseEntity.ok("Cart deleted successfully.");
    }

	//delete all by username
	@DeleteMapping("cart/del/{username}")
	public ResponseEntity<String> deleteCartbyUsername(@PathVariable String username) {

		List<Cart> orders=cartServ.getByUserName(username);
//		System.out.println(orders.toString());
		orderService.addOrders(orders);

		cartServ.deleteCartByUsername(username);
		return ResponseEntity.ok("Cart deleted successfully.");
	}


	//to increment the quantity of items in cart
	@PutMapping("cart/incrementUpdateQuantity/{cartid}")
	public ResponseEntity<Cart> iupdateQuantity(@PathVariable Long cartid){
		return ResponseEntity.ok(cartServ.iupdateQuantity(cartid));
	}
	//to decrement the quantity of items in cart
	@PutMapping("cart/decrementUpdateQuantity/{cartid}")
	public ResponseEntity<Cart> dupdateQuantity(@PathVariable Long cartid){
		return ResponseEntity.ok(cartServ.dupdateQuantity(cartid));
	}


}
