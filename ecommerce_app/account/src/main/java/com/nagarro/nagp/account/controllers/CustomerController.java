package com.nagarro.nagp.account.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.account.dtos.CartDetailsDto;
import com.nagarro.nagp.account.dtos.CartDto;
import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.dtos.PaymentDetailsDto;
import com.nagarro.nagp.account.dtos.ProductDto;
import com.nagarro.nagp.account.restclients.CartRestClient;
import com.nagarro.nagp.account.restclients.OrdersRestClient;
import com.nagarro.nagp.account.restclients.ProductRestClient;
import com.nagarro.nagp.account.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@GetMapping("/products")
	List<ProductDto> getAllProducts() {
		logger.info("Get all products");
		return customerService.getAllProducts();
	}

	@GetMapping("/products/search")
	public List<ProductDto> searchProduct(@RequestParam(required = false) String category,
			@RequestParam(required = false) String name, @RequestParam(required = false) String brand,
			@RequestParam(required = false) String size, @RequestParam(required = false) Double price) {
		logger.info("Search products");

		return customerService.searchProduct(category, name, brand, size, price);

	}

	@GetMapping("/products/{id}")
	public ProductDto getProduct(@PathVariable("id") String id) {
		logger.info("Get product with productId:{}", id);
		return customerService.getProduct(id);
	}

	@PostMapping("/cart")
	public String addtoCart(@RequestBody CartDto cartItem) {
		logger.info("Add item: {} to cart", cartItem);
		return customerService.addItemtoCart(cartItem);
	}

	@GetMapping("/cart")
	public CartDetailsDto getUserCart(@RequestParam String userId) {
		logger.info("Get cart for user with userId: {}", userId);
		return customerService.getUserCart(userId);
	}

	@DeleteMapping("/cart")
	public String removeFromCart(@RequestParam String userId, @RequestParam String productId) {
		logger.info("Delete item from cart with cartId = {} for user with userId: {}", productId, userId);
		return customerService.removeItemFromCart(userId, productId);
	}

	@PutMapping("/cart")
	public String updateQuantity(@RequestParam String userId, @RequestParam String productId, @RequestParam int qty) {
		logger.info("Update cart Qty to = {} with cartId = {} for user with userId: {}", qty, productId, userId);
		return customerService.updateItemQuantity(userId, productId, qty);
	}

	@PostMapping("/cart/checkout")
	public String checkoutAndPlaceOrder(@RequestParam String userId, @RequestBody PaymentDetailsDto paymentDetails) {
		return customerService.checkoutAndPlaceOrder(userId, paymentDetails);
	}

	@GetMapping("/order")
	public List<OrderDto> getOrder(@RequestParam String userId) {
		return customerService.getOrder(userId);
	}

}
