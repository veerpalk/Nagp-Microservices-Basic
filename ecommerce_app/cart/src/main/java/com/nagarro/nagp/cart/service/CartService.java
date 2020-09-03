package com.nagarro.nagp.cart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.nagp.cart.entities.Cart;

public interface CartService {

	List<Cart> getUserCart(String userId);

	ResponseEntity<String> addtoCart(Cart cartItem);

	ResponseEntity<String> removeFromCart(String userId, String productid);

	ResponseEntity<String> updateQuantity(String userId, String productId, int qty);

	ResponseEntity<String> clearCart(String userId);

}