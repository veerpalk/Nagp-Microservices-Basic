package com.nagarro.nagp.cart.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.nagp.cart.cartdb.CartData;
import com.nagarro.nagp.cart.entities.Cart;
import com.nagarro.nagp.cart.services.impl.CartServiceImpl;

@Repository
public class CartRepository {

	Logger logger = LogManager.getLogger(CartRepository.class);
	@Autowired
	private CartData cartData;

	public List<Cart> getUserCart(String userId) {
		return cartData.getCartItems().stream().filter(cart -> cart.getUserId().equals(userId))
				.collect(Collectors.toList());
	}

	public void addtoCart(Cart cartItem) {
		cartData.addToCart(cartItem);
	}

	public void removeFromCart(String userId, String productId) {
		cartData.getCartItems()
				.removeIf(cartItem -> cartItem.getProductId().equals(productId) && cartItem.getUserId().equals(userId));
	}

	public void updateQuantity(String userId, String productId, int qty) {
		cartData.getCartItems().stream()
				.filter(cartItem -> cartItem.getProductId().equals(productId) && cartItem.getUserId().equals(userId))
				.forEach(cart -> cart.setQuantity(qty));
	}

	public void clearCart(String userId) {
		cartData.getCartItems().removeIf(cartItem -> cartItem.getUserId().equals(userId));
	}

}
