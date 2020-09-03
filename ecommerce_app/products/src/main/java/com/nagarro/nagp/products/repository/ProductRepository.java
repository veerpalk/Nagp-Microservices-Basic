package com.nagarro.nagp.products.repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.nagp.products.controllers.ProductsController;
import com.nagarro.nagp.products.entities.Product;
import com.nagarro.nagp.products.enums.BrandName;
import com.nagarro.nagp.products.enums.Category;
import com.nagarro.nagp.products.enums.Size;
import com.nagarro.nagp.products.inventory.ProductInventory;

@Repository
public class ProductRepository {

	Logger logger = LogManager.getLogger(ProductRepository.class);

	@Autowired
	ProductInventory productInventory;

	public List<Product> getAllProducts() {
		logger.info("Getting all the products from db");
		return productInventory.getAllProducts();
	}

	// getProduct byId
	public Product getProduct(String id) {
		logger.info("Getting product with id {} from db", id);
		for (Product product : productInventory.getAllProducts()) {
			if (product.getId().equals(id))
				return product;
		}
		return null;
	}

	public void addProduct(Product product) {
		logger.info("Adding product = {} to db", product);
		product.setId(UUID.randomUUID().toString());
		productInventory.addProduct(product);
	}

	public void deleteProduct(String id) {
		logger.info("Deleting the products with id {} from db", id);
		productInventory.getAllProducts().removeIf(product -> product.getId().equals(id));
	}

	public void updateProduct(Product updateProduct) {
		logger.info("Updating the product = {} from db", updateProduct);
		productInventory.getAllProducts().removeIf(product -> product.getId().equals(updateProduct.getId()));
		productInventory.getAllProducts().add(updateProduct);
	}

	public List<Product> searchProduct(Category category, String name, BrandName brand, Size size, Double price) {

		logger.info("Searching the product from db");
		Double givenPrice = price == null ? Double.MAX_VALUE : price;
		List<Product> filteredList = productInventory.getAllProducts();

		Predicate<Product> pricePredicate = p -> p.getPrice() <= givenPrice;
		Predicate<Product> categoryPredicate = p -> p.getCategory().equals(category);
		Predicate<Product> namePredicate = p -> p.getName().equals(name);
		Predicate<Product> brandPredicate = p -> p.getBrand().equals(brand);
		Predicate<Product> sizePredicate = p -> p.getSize().equals(size);

		filteredList = filteredList.stream().filter(pricePredicate).collect(Collectors.toList());
		if (name != null)
			filteredList = filteredList.stream().filter(namePredicate).collect(Collectors.toList());
		if (brand != null)
			filteredList = filteredList.stream().filter(brandPredicate).collect(Collectors.toList());
		if (category != null)
			filteredList = filteredList.stream().filter(categoryPredicate).collect(Collectors.toList());
		if (size != null)
			filteredList = filteredList.stream().filter(sizePredicate).collect(Collectors.toList());

		return filteredList;
	}

}
