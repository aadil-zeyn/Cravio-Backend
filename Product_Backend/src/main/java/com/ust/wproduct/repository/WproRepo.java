package com.ust.wproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.wproduct.entity.Wproduct;

public interface WproRepo extends JpaRepository<Wproduct,Integer>{

	List<Wproduct> findByRestname(String restName);

	Wproduct findByProduct(String product);
}
