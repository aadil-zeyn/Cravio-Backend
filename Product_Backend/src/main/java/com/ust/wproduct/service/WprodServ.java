package com.ust.wproduct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.wproduct.entity.Wproduct;
@Service
public interface WprodServ {
	Wproduct addProduct(Wproduct prd);
	List<Wproduct> viewAllProd();
	List<Wproduct> viewByRest(String rName);
	Wproduct viewProd(String pname);
	Wproduct updateMenuItem(Wproduct menuNew);



}
