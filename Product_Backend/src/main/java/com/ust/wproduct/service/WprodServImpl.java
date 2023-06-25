package com.ust.wproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.wproduct.entity.Wproduct;
import com.ust.wproduct.repository.WproRepo;

@Service
public class WprodServImpl implements WprodServ {
	@Autowired
	WproRepo repo;

	
	//@Override
	public Wproduct addProduct(Wproduct prd) {
		Wproduct prdSaved=repo.save(prd);
		return prdSaved;}

	//@Override
	public List<Wproduct> viewAllProd(){
		List<Wproduct> allPrd=repo.findAll();
		return allPrd;
	}

	@Override
	public List<Wproduct> viewByRest(String restName) {
		List<Wproduct> list= repo.findByRestname(restName);
		return list;
	}

	@Override
	public Wproduct viewProd(String pname) {
		Wproduct prod = repo.findByProduct(pname);
		return prod;
	}

	@Override
	public Wproduct updateMenuItem(Wproduct menuNew) {
		Wproduct prod = viewProd(menuNew.getProduct());
		if(prod!=null) {
			prod.setPrice(menuNew.getPrice());
			prod.setImage(menuNew.getImage());
			prod.setDescription(menuNew.getDescription());
			prod.setRestname(menuNew.getRestname());
			repo.save(prod);
			return prod;
		}
		else {
			return null;
		}
			
		
	}

	

}
