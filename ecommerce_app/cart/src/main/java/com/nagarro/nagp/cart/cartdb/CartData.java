package com.nagarro.nagp.cart.cartdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.cart.entities.Cart;

@Component
public class CartData {

	private List<Cart> cartItems = new ArrayList<Cart>() {
		{
			add(new Cart("1", "2", "2", 2));
			add(new Cart("2", "3", "2", 2));
			add(new Cart("3", "4", "2", 2));
			add(new Cart("4", "2", "3", 2));
		}
	};

	public void addToCart(Cart item) {
		this.cartItems.add(item);
	}

	public List<Cart> getCartItems() {
		return this.cartItems;
	}

}
