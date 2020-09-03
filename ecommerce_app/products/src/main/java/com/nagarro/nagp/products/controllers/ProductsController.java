package com.nagarro.nagp.products.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.products.entities.Product;
import com.nagarro.nagp.products.enums.BrandName;
import com.nagarro.nagp.products.enums.Category;
import com.nagarro.nagp.products.enums.Size;
import com.nagarro.nagp.products.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
	
	Logger logger = LogManager.getLogger(ProductsController.class);

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<Product> getAllProducts() {
		logger.info("Getting All the Products");
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") String id) {
		logger.info("Get Product with id : {}",id);
		return productService.getProduct(id);
	}

	@PostMapping("")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		logger.info("Add Product: {}",product);
		return productService.addProduct(product);
	}

	@PutMapping("")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
	return	productService.updateProduct(product);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {
		logger.info("Delete Product with id : {}",id);
		return productService.deleteProduct(id);
	}

	
	@GetMapping("/search")
	public List<Product> searchProduct(@RequestParam(required = false) Category category, @RequestParam(required = false) String name,
			@RequestParam(required = false) BrandName brand, @RequestParam(required = false) Size size,
			@RequestParam(required = false) Double price) { 

		logger.info("Searching Product..");
		return productService.searchProduct(category, name, brand, size, price);

	}
}
