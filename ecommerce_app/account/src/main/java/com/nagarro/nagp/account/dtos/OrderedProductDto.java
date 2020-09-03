package com.nagarro.nagp.account.dtos;

public class OrderedProductDto {
	
	private String id;
	private String productId;
	private int quantity;
	
	public OrderedProductDto() {}
	public OrderedProductDto(String id, String productId, int quantity) {
		this.id = id;
		this.productId = productId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
