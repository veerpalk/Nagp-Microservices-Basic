package com.nagarro.nagp.account.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.nagp.account.dtos.CartDetailsDto;
import com.nagarro.nagp.account.dtos.CartDto;
import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.dtos.PaymentDetailsDto;
import com.nagarro.nagp.account.dtos.ProductDto;

public interface CustomerService {

	CartDetailsDto getUserCart(String userId);

	String removeItemFromCart(String userId, String productId);

	String updateItemQuantity(String userId, String productId, int qty);

	String checkoutAndPlaceOrder(String userId, PaymentDetailsDto paymentDetails);

	List<OrderDto> getOrder(String userId);

	String addItemtoCart(CartDto cartItem);
	
	List<ProductDto> searchProduct(String category, String name, String brand, String size, Double price);

	ProductDto getProduct(String id);
	
	List<ProductDto> getAllProducts();

}