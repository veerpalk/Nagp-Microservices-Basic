package com.nagarro.nagp.account.restclients;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nagarro.nagp.account.dtos.ProductDto;

@Service
public class ProductRestClient {

	Logger logger = LogManager.getLogger(ProductRestClient.class);

	@Autowired
	private RestTemplate restTemplate;

	public final String PRODUCTS_BASE_URL = "http://products/products";

	private <T> List<T> toList(T[] array) {
		return Arrays.asList(array);
	}

	public List<ProductDto> getAllProduct() {
		logger.info("Calling Product restClient to get all products with url:{}", PRODUCTS_BASE_URL);
		return toList(restTemplate.getForObject(PRODUCTS_BASE_URL, ProductDto[].class));
	}

	public List<ProductDto> searchProduct(String category, String name, String brand, String size, Double price) {

		StringBuilder url = new StringBuilder(PRODUCTS_BASE_URL).append("/search");

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.toString());
		if (category != null)
			builder.queryParam("category", category);
		if (name != null)
			builder.queryParam("name", name);
		if (brand != null)
			builder.queryParam("brand", brand);
		if (size != null)
			builder.queryParam("size", size);
		if (price != null)
			builder.queryParam("price", price);

		logger.info("Calling Product restClient to search url:{}", builder.buildAndExpand().toUri());

		ResponseEntity<ProductDto[]> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET,
				null, ProductDto[].class);
		return toList(response.getBody());
	}

	public ProductDto getProduct(String id) {
		Map<String, String> urlParams = new HashMap<String, String>();
		urlParams.put("id", id);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(PRODUCTS_BASE_URL + "/" + id);

		logger.info("Calling Product restClient to get product:{} with url:{}", id, builder.buildAndExpand().toUri());

		ResponseEntity<ProductDto> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET,
				null, ProductDto.class);

		return response.getBody();
	}

	public ResponseEntity<String> addProduct(ProductDto product) {
		logger.info("Calling Product restClient to adding product = {} with url:{}", product, PRODUCTS_BASE_URL);
		return restTemplate.postForEntity(PRODUCTS_BASE_URL, product, String.class);
	}

	public ResponseEntity<String> deleteProduct(String id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(PRODUCTS_BASE_URL + "/" + id);
		logger.info("Calling Product restClient to delte product:{} with url:{}", id, builder.buildAndExpand().toUri());
		return restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.DELETE, null, String.class);
	}

	public ResponseEntity<String> updateProduct(ProductDto product) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(PRODUCTS_BASE_URL);
		logger.info("Calling Product restClient to update product = {} with url:{}", product, PRODUCTS_BASE_URL);
		return restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, null, String.class);
	}

}
