package com.capstone.cart;

import com.capstone.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.mail.MessagingException;

@SpringBootApplication
@EnableEurekaClient
public class CartApplication {
//	@Autowired
//	private CartService senderService;

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() throws MessagingException {
//		senderService.sendSimpleEmail("aadil.245268@gmail.com",
//				"This is email body",
//				"This is email subject");
//
//	}

}
