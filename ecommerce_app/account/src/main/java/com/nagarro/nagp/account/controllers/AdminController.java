package com.nagarro.nagp.account.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.dtos.ProductDto;
import com.nagarro.nagp.account.entities.User;
import com.nagarro.nagp.account.service.AccountService;
import com.nagarro.nagp.account.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	Logger logger = LogManager.getLogger(CustomerController.class);
	public static final String ROLE_DELIVERY_TEAM = "ROLE_DELIVERY_TEAM";

	@Autowired
	private AccountService accountService;

	@Autowired
	private AdminService adminService;

	@GetMapping("")
	public List<User> getAllUsers() {
		return accountService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		return accountService.getUser(id);
	}

	@PostMapping("")
	public ResponseEntity<String> addUser(@RequestBody User User) {
		return accountService.addUser(User);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
		return accountService.deleteUser(id);
	}

	@PostMapping("/products")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto product) {
		return adminService.addProduct(product);
	}

	@PutMapping("/products")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto product) {
		return adminService.updateProduct(product);
	}

	@DeleteMapping("products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {
		return adminService.deleteProduct(id);
	}

	@GetMapping("/products")
	List<ProductDto> getAllProducts() {
		logger.info("Get all products");
		return adminService.getAllProducts();
	}

	@GetMapping("/products/search")
	public List<ProductDto> searchProduct(@RequestParam(required = false) String category,
			@RequestParam(required = false) String name, @RequestParam(required = false) String brand,
			@RequestParam(required = false) String size, @RequestParam(required = false) Double price) {
		logger.info("Search products");

		return adminService.searchProduct(category, name, brand, size, price);

	}

	@GetMapping("/products/{id}")
	public ProductDto getProduct(@PathVariable("id") String id) {
		logger.info("Get product with productId:{}", id);
		return adminService.getProduct(id);
	}

	@PutMapping("/orders")
	public ResponseEntity<String> updateOrderStatus(@RequestParam String orderId, @RequestParam String status) {
		return adminService.updateOrderStatus(orderId, status);
	}

	@GetMapping("/orders/all")
	public List<OrderDto> getAllOrders() {
		logger.info("Get all orders");
		return adminService.getAllOrders();
	}

}
