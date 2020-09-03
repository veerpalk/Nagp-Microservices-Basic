package com.nagarro.nagp.order.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.order.entities.Order;
import com.nagarro.nagp.order.enums.ErrorCode;
import com.nagarro.nagp.order.enums.OrderStatus;
import com.nagarro.nagp.order.exceptions.DataNotFoundException;
import com.nagarro.nagp.order.repository.OrderRepository;
import com.nagarro.nagp.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	Logger logger = LogManager.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> getAllOrders() {
		logger.info("Get all orders from repository");
		List<Order> orders = orderRepository.getAllOrders();
		if (orders.isEmpty())
			throw new DataNotFoundException(ErrorCode.NO_DATA_DOUND);
		return orders;
	}

	@Override
	public List<Order> getOrder(String userId) {
		logger.info("Get order for user with userId:{} from repository", userId);
		List<Order> orders = orderRepository.getOrders(userId);
		if (orders.isEmpty())
			throw new DataNotFoundException(ErrorCode.NO_DATA_DOUND);
		return orders;

	}

	@Override
	public ResponseEntity<String> updateOrderStatus(String id, OrderStatus status) {
		logger.info("Update order status as={} with orderId: {}", status, id);
		Order order = orderRepository.updateOrderStatus(id, status);
		if (order != null)
			return new ResponseEntity<String>("Order Status Updated to " + status, HttpStatus.OK);
		throw new DataNotFoundException(ErrorCode.NO_ORDER_FOUND);
	}

	@Override
	public ResponseEntity<String> addOrder(Order order) {
		logger.info("Add order = {} by repository", order);
		orderRepository.addOrder(order);
		return new ResponseEntity<String>("Order got placed with orderid "+order.getId(), HttpStatus.OK);

	}

}
