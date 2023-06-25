package com.ust.wproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.wproduct.entity.Restaurant;
import com.ust.wproduct.entity.Wproduct;
import com.ust.wproduct.service.RestaurantService;
import com.ust.wproduct.service.WprodServ;

@RestController
@RequestMapping("/allproducts")
@CrossOrigin()
public class WproductController {
	@Autowired
	WprodServ PServ;
	
	@Autowired
	RestaurantService restServ;
	
	@PostMapping("/addProd")
	public ResponseEntity<?> addPrd(@RequestBody Wproduct prd)
	{
		Wproduct prd1 = PServ.addProduct(prd);
		return new ResponseEntity<Wproduct>(prd1,HttpStatus.OK);
	}
	@GetMapping("/viewAllProd")
	public ResponseEntity<?> showAllProd(){
		List<Wproduct> viewAllProd=PServ.viewAllProd();
		return new ResponseEntity<List<Wproduct>>(viewAllProd,HttpStatus.OK);
	}
	@GetMapping("/viewProd/{pname}")
	public ResponseEntity<?> showProd(@PathVariable String pname){
		Wproduct viewProd=PServ.viewProd(pname);
		return new ResponseEntity<Wproduct>(viewProd,HttpStatus.OK);
	}
	
	@GetMapping("/viewRestMenu/{rName}")
	public ResponseEntity<?> getMenuByRest(@PathVariable String rName){
		List<Wproduct> menu = PServ.viewByRest(rName);
		return ResponseEntity.ok().body(menu);
	}
	
	@GetMapping("/viewRest")
	public ResponseEntity<?> showAllRest(){
		List<Restaurant> viewAllRest=restServ.allRest();
		return new ResponseEntity<List<Restaurant>>(viewAllRest,HttpStatus.OK);
	}
	@PostMapping("/addRest")
	public ResponseEntity<?> addRestaurant(@RequestBody Restaurant rest)
	{
		Restaurant r = restServ.addRest(rest);
		return new ResponseEntity<Restaurant>(r,HttpStatus.OK);
	}
	
	@PutMapping("/updMenu")
	public ResponseEntity<?> updateMenu(@RequestBody Wproduct menuNew){
		Wproduct menu = PServ.updateMenuItem(menuNew);
		if(menu != null) {
			return ResponseEntity.ok().body(menu);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/getRestName")
	public ResponseEntity<?> getAllRestName (){
		List<String> rests = restServ.getRest();
		return ResponseEntity.ok().body(rests);
	}
	
	
	
	

}
