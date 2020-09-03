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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nagarro.nagp.account.dtos.CartDetailsDto;
import com.nagarro.nagp.account.dtos.CartDto;
import com.nagarro.nagp.account.dtos.ProductDto;
import com.nagarro.nagp.account.dtos.UserCartDTO;

/**
 * @author Admin
 *
 */
@Service
public class CartRestClient {

	Logger logger = LogManager.getLogger(CartRestClient.class);

	@Autowired
	private ProductRestClient productRestClient;

	@Autowired
	private RestTemplate restTemplate;

	public static final String CART_BASE_URL = "http://cart/cart";

	/**
	 * @param cartItem
	 * @return
	 */
	public String addItemtoCart(CartDto cartItem) {
		logger.info("Calling Cart restClient to adding item = {} with url:{}", cartItem, CART_BASE_URL);
		ResponseEntity<String> response = restTemplate.postForEntity(CART_BASE_URL, cartItem, String.class);
		return response.getBody();
	}

	private <T> List<T> toList(T[] array) {
		return Arrays.asList(array);
	}

	/**
	 * @param userId
	 * @return
	 */
	public CartDetailsDto getUserCart(String userId) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(CART_BASE_URL.toString()).queryParam("userId",
				userId);
		logger.info("Calling Cart restClient to get cart for user with userId:{} with url:{}", userId,
				builder.buildAndExpand().toUri());

		ResponseEntity<UserCartDTO[]> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET,
				null, UserCartDTO[].class);
		List<UserCartDTO> cartItems = toList(response.getBody());
		Double totalPrice = 0.00;
		for (UserCartDTO cartItem : cartItems) {
			ProductDto product = productRestClient.getProduct(cartItem.getProductId());
			if (product != null) {
				cartItem.setCategory(product.getCategory());
				cartItem.setName(product.getName());
				cartItem.setSize(product.getSize());
				cartItem.setPrice(product.getPrice());
				cartItem.setBrand(product.getBrand());
				cartItem.setColor(product.getColor());
				totalPrice += product.getPrice() * cartItem.getQuantity();
			}
		}

		CartDetailsDto cartDetails = new CartDetailsDto();
		cartDetails.setTotalPrice(totalPrice);
		cartDetails.setCartItems(cartItems);
		return cartDetails;
	}

	/**
	 * @param userId
	 * @param productId
	 * @return
	 */
	public String removeItemFromCart(String userId, String productId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(CART_BASE_URL.toString())
				.queryParam("userId", userId).queryParam("productId", productId);
		logger.info("Calling Cart restClient to delete cart with cartId:{} for user with userId:{} with url:{}",
				productId, userId, builder.buildAndExpand().toUri());

		ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.DELETE,
				null, String.class);
		return response.getBody();
	}

	/**
	 * @param userId
	 * @param productId
	 * @param qty
	 * @return
	 */
	public String updateItemQuantity(String userId, String productId, int qty) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(CART_BASE_URL).queryParam("userId", userId)
				.queryParam("productId", productId).queryParam("qty", qty);
		logger.info(
				"Calling Cart restClient to update cart quantity to {} with cartId:{} for user with userId:{} with url:{}",
				qty, productId, userId, builder.buildAndExpand().toUri());
		ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, null,
				String.class);
		return response.getBody();
	}

	/**
	 * @param userId
	 * @return
	 */
	public String clearUserCart(@RequestParam String userId) {
		StringBuilder url = new StringBuilder(CART_BASE_URL).append("/clear");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.toString()).queryParam("userId", userId)
				.queryParam("userId", userId);

		logger.info("Calling Cart restClient to clear cart for user with userId:{} with url:{}", userId,
				builder.buildAndExpand().toUri());
		ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.DELETE,
				null, String.class);
		return response.getBody();
	}

}
