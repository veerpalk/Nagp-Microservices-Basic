package com.nagarro.nagp.products.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.nagp.products.entities.Product;
import com.nagarro.nagp.products.enums.BrandName;
import com.nagarro.nagp.products.enums.Category;
import com.nagarro.nagp.products.enums.Size;

@Service
public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProduct(String id);

	public ResponseEntity<String> addProduct(Product product);

	public ResponseEntity<String> deleteProduct(String id);

	public List<Product> searchProduct(Category catergory, String name, BrandName brand, Size size, Double price);

	ResponseEntity<String> updateProduct(Product pdt);

}
