package com.nagarro.nagp.account.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.dtos.ProductDto;

public interface AdminService {

	ResponseEntity<String> addProduct(ProductDto product);

	ResponseEntity<String> deleteProduct(String id);

	ResponseEntity<String> updateProduct(ProductDto product);

	ResponseEntity<String> updateOrderStatus(String orderId, String status);
	
	List<ProductDto> searchProduct(String category, String name, String brand, String size, Double price);

	ProductDto getProduct(String id);
	
	List<ProductDto> getAllProducts();

	List<OrderDto> getAllOrders();

}
