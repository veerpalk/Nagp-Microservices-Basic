package com.nagarro.nagp.account.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.account.controllers.CustomerController;
import com.nagarro.nagp.account.dtos.CartDetailsDto;
import com.nagarro.nagp.account.dtos.CartDto;
import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.dtos.PaymentDetailsDto;
import com.nagarro.nagp.account.dtos.ProductDto;
import com.nagarro.nagp.account.restclients.CartRestClient;
import com.nagarro.nagp.account.restclients.OrdersRestClient;
import com.nagarro.nagp.account.restclients.ProductRestClient;
import com.nagarro.nagp.account.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

	@Autowired
	ProductRestClient productRestClient;

	@Autowired
	CartRestClient cartRestClient;

	@Autowired
	OrdersRestClient orderRestClient;
	
	@Override
	public CartDetailsDto getUserCart(String userId) {
		logger.info("Get cart for user with userId: {}", userId);
		return cartRestClient.getUserCart(userId);
	}

	@Override
	public String removeItemFromCart(String userId, String productId) {
		logger.info("Delete item from cart with cartId = {} for user with userId: {}", productId, userId);
		return cartRestClient.removeItemFromCart(userId, productId);
	}

	@Override
	public String updateItemQuantity(String userId, String productId, int qty) {
		logger.info("Update cart Qty to = {} with cartId = {} for user with userId: {}", qty, productId, userId);
		return cartRestClient.updateItemQuantity(userId, productId, qty);
	}

	@Override
	public String checkoutAndPlaceOrder(String userId, PaymentDetailsDto paymentDetails) {
		logger.info("Checkout cart for user with userId: {}", userId);
		String message = "Sorry!! couldn't place order due to some error.. Please try again";
		String response = orderRestClient.placeOrder(userId, paymentDetails);
		return "Congratulations "+response;

	}

	@Override
	public List<OrderDto> getOrder(String userId) {
		return orderRestClient.getOrder(userId);
	}

	@Override
	public String addItemtoCart(CartDto cartItem) {
		return cartRestClient.addItemtoCart(cartItem);
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


}
