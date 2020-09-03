package com.nagarro.nagp.products.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.products.controllers.ProductsController;
import com.nagarro.nagp.products.entities.Product;
import com.nagarro.nagp.products.enums.BrandName;
import com.nagarro.nagp.products.enums.Category;
import com.nagarro.nagp.products.enums.ErrorCode;
import com.nagarro.nagp.products.enums.Size;
import com.nagarro.nagp.products.exceptions.DataNotFoundException;
import com.nagarro.nagp.products.repository.ProductRepository;
import com.nagarro.nagp.products.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		logger.info("Calling repository to get All Products");
		List<Product> products = productRepository.getAllProducts();
		if (products.isEmpty())
			throw new DataNotFoundException(ErrorCode.NO_DATA_DOUND);
		return products;
	}

	@Override
	public Product getProduct(String id) {
		logger.info("Calling repository to get Product with id:{}", id);
		Product product = productRepository.getProduct(id);
		if (product != null)
			return product;
		throw new DataNotFoundException(ErrorCode.NO_DATA_DOUND);
	}

	@Override
	public ResponseEntity<String> addProduct(Product product) {
		logger.info("Calling repository to add Product:{}", product);
		productRepository.addProduct(product);
		return new ResponseEntity<String>("Product added to inventory", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteProduct(String id) {
		logger.info("Calling repository to delete Product with id:{}", id);
		productRepository.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);

	}

	@Override
	public List<Product> searchProduct(Category category, String name, BrandName brand, Size size, Double price) {

		logger.info("Calling repository to search Product");
		List<Product> products = productRepository.searchProduct(category, name, brand, size, price);
		if (products != null)
			return products;
		throw new DataNotFoundException(ErrorCode.NO_DATA_DOUND);

	}

	@Override
	public ResponseEntity<String> updateProduct(Product pdt) {

		productRepository.getAllProducts().removeIf(product -> product.getId().equals(pdt.getId()));
		productRepository.getAllProducts().add(pdt);
		return new ResponseEntity<String>("Product updated successfully", HttpStatus.OK);
	}

}
