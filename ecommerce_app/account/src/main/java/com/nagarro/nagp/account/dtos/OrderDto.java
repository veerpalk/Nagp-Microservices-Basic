package com.nagarro.nagp.account.dtos;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {

	private String id;
	private String userId;
	private String status;
	private LocalDate createdDate;

	private List<OrderedProductDto> orderedProducts;

	public OrderDto() {
	}

	public OrderDto(String id, String userId, String status, LocalDate createdDate,
			List<OrderedProductDto> orderedProducts) {
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.createdDate = createdDate;
		this.orderedProducts = orderedProducts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public List<OrderedProductDto> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProductDto> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

}
