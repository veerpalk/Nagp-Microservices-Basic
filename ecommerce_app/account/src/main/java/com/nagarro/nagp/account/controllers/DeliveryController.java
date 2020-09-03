package com.nagarro.nagp.account.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.service.AdminService;

@RestController
@RequestMapping(value = "/delivery")
public class DeliveryController {
	
	Logger logger = LogManager.getLogger(CustomerController.class);
	public static final String ROLE_DELIVERY_TEAM = "ROLE_DELIVERY_TEAM";

	@Autowired
	private AdminService adminService;

	@Secured({ROLE_DELIVERY_TEAM})
	@PutMapping("/orders")
	public ResponseEntity<String> updateOrderStatus(@RequestParam String orderId, @RequestParam String status) {
		return adminService.updateOrderStatus(orderId, status);
	}
	
	@Secured({ROLE_DELIVERY_TEAM})
	@GetMapping("/orders/all")
	public List<OrderDto> getAllOrders() {
		logger.info("Get all orders");
		return adminService.getAllOrders();
	}

}
