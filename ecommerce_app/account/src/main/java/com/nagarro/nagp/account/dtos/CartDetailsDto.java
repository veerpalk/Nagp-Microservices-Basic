package com.nagarro.nagp.account.dtos;

import java.util.List;

public class CartDetailsDto {

//	private List<CartDto> cartItems;
	private List<UserCartDTO> cartItems;
	private Double totalPrice;

	public CartDetailsDto() {
	}

	public CartDetailsDto(List<UserCartDTO> cartItems, Double totalPrice) {
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
	}

	public List<UserCartDTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<UserCartDTO> cartItems) {
		this.cartItems = cartItems;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
