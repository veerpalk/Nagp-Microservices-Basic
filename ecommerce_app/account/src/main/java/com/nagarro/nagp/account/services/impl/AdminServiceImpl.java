package com.nagarro.nagp.account.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.dtos.ProductDto;
import com.nagarro.nagp.account.restclients.OrdersRestClient;
import com.nagarro.nagp.account.restclients.ProductRestClient;
import com.nagarro.nagp.account.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	Logger logger = LogManager.getLogger(AdminServiceImpl.class);

	@Autowired
	ProductRestClient productRestClient;

	@Autowired
	OrdersRestClient ordersRestClient;

	@Override
	public ResponseEntity<String> addProduct(ProductDto product) {
		return productRestClient.addProduct(product);
	}

	@Override
	public ResponseEntity<String> deleteProduct(String id) {
		return productRestClient.deleteProduct(id);
	}

	@Override
	public ResponseEntity<String> updateProduct(ProductDto product) {
		return productRestClient.updateProduct(product);
	}

	public ResponseEntity<String> updateOrderStatus(String orderId, String status) {
		return ordersRestClient.updateOrderStatus(orderId, status);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		logger.info("Get all products");
		return productRestClient.getAllProduct();
	}

	@Override
	public List<ProductDto> searchProduct(String category, String name, String brand, String size, Double price) {
		logger.info("Search products");

		return productRestClient.searchProduct(category, name, brand, size, price);

	}

	@Override
	public ProductDto getProduct(String id) {
		logger.info("Get product with productId:{}", id);
		return productRestClient.getProduct(id);
	}

	@Override
	public List<OrderDto> getAllOrders() {

		return ordersRestClient.getAllOrders();
	}
}
