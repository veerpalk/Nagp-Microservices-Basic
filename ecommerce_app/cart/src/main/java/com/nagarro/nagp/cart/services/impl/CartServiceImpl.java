package com.nagarro.nagp.cart.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.cart.controllers.CartController;
import com.nagarro.nagp.cart.entities.Cart;
import com.nagarro.nagp.cart.enums.ErrorCode;
import com.nagarro.nagp.cart.exceptions.DataNotFoundException;
import com.nagarro.nagp.cart.repositories.CartRepository;
import com.nagarro.nagp.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	Logger logger = LogManager.getLogger(CartServiceImpl.class);

	@Autowired
	CartRepository cartRepository;

	@Override
	public List<Cart> getUserCart(String userId) {
		List<Cart> userCart = cartRepository.getUserCart(userId);
		if(userCart.isEmpty())
			throw new DataNotFoundException(ErrorCode.NO_DATA_DOUND);
		return userCart;
	}

	@Override
	public ResponseEntity<String> addtoCart(Cart cartItem) {
		cartRepository.addtoCart(cartItem);
		return new ResponseEntity<String>("Item has been added to Cart",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> removeFromCart(String userId, String productId) {
		cartRepository.removeFromCart(userId, productId);
		return new ResponseEntity<String>("Item removed from cart with id "+productId,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> updateQuantity(String userId, String productId, int qty) {
		cartRepository.updateQuantity(userId, productId, qty);
		return new ResponseEntity<String>("Item quantity updated to "+qty,HttpStatus.OK);

	}
	
	@Override
	public ResponseEntity<String> clearCart(String userId) {
		cartRepository.clearCart(userId);
		return new ResponseEntity<String>("Cart has been cleared",HttpStatus.OK);

	}

}
