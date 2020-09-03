package com.nagarro.nagp.cart.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.cart.entities.Cart;
import com.nagarro.nagp.cart.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

	Logger logger = LogManager.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@GetMapping("")
	public List<Cart> getUserCart(@RequestParam String userId) {
		logger.info("Get cart for user:{}", userId);
		return cartService.getUserCart(userId);
	}

	@PostMapping("")
	public ResponseEntity<String> addtoCart(@RequestBody Cart cartItem) {
		logger.info("Add cart item", cartItem);
		return cartService.addtoCart(cartItem);
	}

	@DeleteMapping("")
	public ResponseEntity<String> removeFromCart( @RequestParam String userId,@RequestParam String productId) {
		logger.info("Delete cartItem:{} for user:{}", productId, userId);
		return cartService.removeFromCart(userId, productId);
	}

	@PutMapping("")
	public ResponseEntity<String> updateQuantity(@RequestParam String userId, @RequestParam String productId, @RequestParam int qty) {
		logger.info("Update quantity:{} for cart:{} of user:{}", qty, productId, userId);
		return cartService.updateQuantity(userId, productId, qty);
	}

	@DeleteMapping("/clear")
	public ResponseEntity<String> clearCart(@RequestParam String userId) {
	logger.info("Clear cart for user:{}", userId);
		return cartService.clearCart(userId);
}

}
