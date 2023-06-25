package com.ust.wproduct.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.wproduct.entity.Restaurant;
import com.ust.wproduct.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restRepo;
	
	public List<Restaurant> allRest(){
		return restRepo.findAll();
	}
	
	public Restaurant addRest(Restaurant r) {
		return restRepo.save(r);
	}

	public List<String> getRest() {
		// TODO Auto-generated method stub
		List<Restaurant> restaurants = restRepo.findAll();
		 List<String> restaurantNames = restaurants.stream()
		            .map(Restaurant::getRestName) // Assuming the getter method for restName is getRestName()
		            .collect(Collectors.toList());

		    return restaurantNames;
		
	}

}
