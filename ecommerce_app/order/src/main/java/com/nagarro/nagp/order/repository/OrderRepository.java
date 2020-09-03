package com.nagarro.nagp.order.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.nagp.order.entities.Order;
import com.nagarro.nagp.order.enums.OrderStatus;
import com.nagarro.nagp.order.orderdb.OrderDb;

@Repository
public class OrderRepository {

	Logger logger = LogManager.getLogger(OrderRepository.class);

	@Autowired
	OrderDb orderDb;

	public List<Order> getOrders(String userId) {
		logger.info("Getting order from db for user with userId = {}", userId);

		return orderDb.getOrders().stream().filter(order -> order.getUserId().equals(userId))
				.collect(Collectors.toList());

	}

	public List<Order> getAllOrders() {
		logger.info("Getting All order from db ");
		return orderDb.getOrders();
	}

	public Order updateOrderStatus(String id, OrderStatus status) {
		logger.info("Set order status as:{} for order with id:{}", status, id);
		for (Order order : orderDb.getOrders()) {
			if (order.getId().equals(id)) {
				order.setStatus(status);
				return order;
			}
		}
		return null;
	}

	public String addOrder(Order order) {
		logger.info("Add Order:{} to db", order);
		order.setId(UUID.randomUUID().toString());
		order.setStatus(OrderStatus.ORDERED);
		order.setCreatedDate(LocalDate.now());
		orderDb.addOrder(order);
		return order.getId();
	}

}
