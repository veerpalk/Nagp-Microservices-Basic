package com.nagarro.nagp.order.entities;

import java.time.LocalDate;
import java.util.List;

import com.nagarro.nagp.order.enums.OrderStatus;

public class Order {

	private String id;
	private String userId;
	private OrderStatus status;
	private LocalDate createdDate;

	private List<OrderedProduct> orderedProducts;

	public Order(String id, String userId, OrderStatus status, LocalDate createdDate,
			List<OrderedProduct> orderedProducts) {
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.createdDate = createdDate;
		this.orderedProducts = orderedProducts;
	}

	public Order() {}

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

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	

}
