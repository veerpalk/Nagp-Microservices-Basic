package com.nagarro.nagp.cart.dtos;

import java.util.List;

import com.nagarro.nagp.cart.entities.Cart;

public class CartDetails {
	private List<Cart> cartItems;
	private Double totalPrice;

	public CartDetails() {
	}

	public CartDetails(List<Cart> cartItems, Double totalPrice) {
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
	}

	public List<Cart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Cart> cartItems) {
		this.cartItems = cartItems;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
