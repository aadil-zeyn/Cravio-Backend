package com.capstone.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.cart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

//	public List<Cart> findByUserid(Long id);
	
//	public void deleteByCartidAndUserid(Long cId, Long uId);

	List<Cart> findAllByRestName(String restName);

	public List<Cart> findByUsername(String userName);

	void deleteByCartidAndUsername(Long cartId, String username);

    Optional<Cart> findByProdid(Long prodid);

    List<Cart> findAllByUsername(String username);

	Optional<Cart> findByProdidAndUsername(Long prodid, String username);

    void deleteAllByUsername(String username);
}
