package com.nagarro.nagp.cart.entities;

public class Cart {

	private String id;
	private String productId;
	private String userId;
	private int quantity;

	public Cart(String id, String productId, String userId, int quantity) {
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
