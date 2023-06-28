package com.capstone.cart.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.capstone.cart.model.Cart;
import com.capstone.cart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepo;

	/**
	 * Retrieves a Cart by its cartId.
	 *
	 * @param cartId the cartId to search for
	 * @return the Cart object if found, otherwise null
	 */
	@Transactional
	public Cart getByCartId(Long cartId) {
		Optional<Cart> cart = cartRepo.findById(cartId);
		if (cart.isPresent())
			return cart.get();
		else
			return null;
	}

	/**
	 * Retrieves a list of Carts by a userId.
	 *
	 * @param userId the userId to search for
	 * @return the list of Cart objects if found, otherwise null
	 */
	@Transactional
	public List<Cart> getByUserName(String userName) {
		List<Cart> userCarts = cartRepo.findByUsername(userName);
		if (userCarts != null)
			return userCarts;
		else
			return null;
	}

	/**
	 * Adds a new Cart.
	 *
	 * @param c the Cart object to be added
	 * @return the saved Cart object
	 */
	@Transactional
	public Cart addCart(Cart c) {
		Cart exist = null;
		Optional<Cart> opt = cartRepo.findByProdid(c.getProdid());
		if (opt.isPresent()&&(opt.get().getUsername()==c.getUsername())) {
			exist = opt.get();
			exist.setQuantity(exist.getQuantity() + 1);
			exist.setTotal(exist.getQuantity() * c.getPrice());
			return cartRepo.save(exist);
		} else {
			c.setStatus("In progress");
			c.setQuantity(1L);
			c.setTotal(c.getQuantity() * c.getPrice());
			Cart saveCart = cartRepo.save(c);
			System.out.println("added");
			return saveCart;
		}

	}

	/**
	 * Deletes a Cart by its cartId and userId.
	 *
	 * @param cartId the cartId to delete
	 * @param userId the userId to delete
	 */
	@Transactional
	public void deleteCartByCartIdAndUsername(Long cartId, String username) {
		cartRepo.deleteByCartidAndUsername(cartId, username);
		System.out.println("deleted");
	}
//
//	@Autowired
//	private JavaMailSender mailSender;
//
//	/**
//	 * Sends a simple email using the provided details.
//	 *
//	 * @param toEmail  the recipient's email address
//	 * @param subject  the email subject
//	 * @param body     the email body
//	 */
//	public void sendSimpleEmail(String toEmail, String subject, String body) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("farmersust@gmail.com");
//		message.setTo(toEmail);
//		message.setText(body);
//		message.setSubject(subject);
//		mailSender.send(message);
//		System.out.println("Mail Send...");
//	}

	/**
	 * Updates the quantity of a Cart by incrementing it by 1.
	 *
	 * @param cartid the cartId of the Cart to update
	 * @return the updated Cart object
	 */
	public Cart iupdateQuantity(Long cartid) {
		Cart c = cartRepo.findById(cartid).orElse(null);
		c.setQuantity(c.getQuantity() + 1);
		cartRepo.save(c);
		return c;
	}

	/**
	 * Updates the quantity of a Cart by decrementing it by 1.
	 *
	 * @param cartid the cartId of the Cart to update
	 * @return the updated Cart object
	 */
	public Cart dupdateQuantity(Long cartid) {
		Cart c = cartRepo.findById(cartid).orElse(null);
		if(c.getQuantity()>0)
		c.setQuantity(c.getQuantity() - 1);
		cartRepo.save(c);
		return c;
	}
}
