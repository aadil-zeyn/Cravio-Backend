package com.ust.wproduct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.wproduct.entity.Wproduct;
import com.ust.wproduct.exception.ProductAlreadyExists;
@Service
public interface WprodServ {
	Wproduct addProduct(Wproduct prd) throws ProductAlreadyExists;
	List<Wproduct> viewAllProd();
	List<Wproduct> viewByRest(String rName);
	Wproduct viewProd(String pname);
	Wproduct updateMenuItem(Wproduct menuNew);



}
