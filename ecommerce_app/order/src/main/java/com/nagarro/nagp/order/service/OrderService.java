package com.nagarro.nagp.order.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.nagp.order.entities.Order;
import com.nagarro.nagp.order.enums.OrderStatus;

public interface OrderService {

	List<Order> getAllOrders();

	List<Order> getOrder(String userId);

	ResponseEntity<String> updateOrderStatus(String id, OrderStatus status);

	ResponseEntity<String> addOrder(Order order);

}