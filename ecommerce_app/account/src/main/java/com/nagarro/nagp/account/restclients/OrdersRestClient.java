package com.nagarro.nagp.account.restclients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
import com.nagarro.nagp.account.dtos.OrderDto;
import com.nagarro.nagp.account.dtos.OrderedProductDto;
import com.nagarro.nagp.account.dtos.PaymentDetailsDto;
import com.nagarro.nagp.account.dtos.UserCartDTO;
import com.nagarro.nagp.account.enums.ErrorCode;
import com.nagarro.nagp.account.exceptions.OrderNotPLacedException;

@Service
public class OrdersRestClient {

	Logger logger = LogManager.getLogger(OrdersRestClient.class);

	@Autowired
	PaymentRestClient paymentRestClient;

	@Autowired
	CartRestClient cartRestClient;

	@Autowired
	private RestTemplate restTemplate;

	public final String ORDER_BASE_URL = "http://order/order";

	public List<OrderDto> getOrder(@RequestParam String userId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(ORDER_BASE_URL).queryParam("userId", userId);
		logger.info("Calling order restClient to get order for user with userId:{} with url:{}", userId,
				builder.buildAndExpand().toUri());
		ResponseEntity<OrderDto[]> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET,
				null, OrderDto[].class);
		return toList(response.getBody());
	}

	public List<OrderDto> getAllOrders() {

		StringBuilder url = new StringBuilder(ORDER_BASE_URL).append("/all");

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.toString());

		logger.info("Calling order restClient to get all orders with url:{}", builder.buildAndExpand().toUri());

		ResponseEntity<OrderDto[]> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET,
				null, OrderDto[].class);
		return toList(response.getBody());
	}

	public ResponseEntity<String> updateOrderStatus(String orderId, String status) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(ORDER_BASE_URL).queryParam("orderId", orderId)
				.queryParam("status", status);

		logger.info("Calling order restClient to update orders status={} with orderId={} with url:{}", status, orderId,
				builder.buildAndExpand().toUri());

		return restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, null, String.class);

	}

	private <T> List<T> toList(T[] array) {
		return Arrays.asList(array);
	}

	public String placeOrder(String userId, PaymentDetailsDto paymentDetails) {

		logger.info("START:Placing order...");
		// addPayment
		logger.info("Making payment...");
		Boolean isPaymentSuccessFull = paymentForOrder(userId, paymentDetails);
		// addOrder
		if (isPaymentSuccessFull) {
			CartDetailsDto cartDetailsDto = cartRestClient.getUserCart(userId);
			OrderDto orderDto = new OrderDto();
			List<OrderedProductDto> orderedProductsDto = new ArrayList<OrderedProductDto>();
			orderDto.setUserId(userId);
			for (UserCartDTO userCart : cartDetailsDto.getCartItems()) {
				OrderedProductDto orderedProductDto = new OrderedProductDto();
				orderedProductDto.setId(UUID.randomUUID().toString());
				orderedProductDto.setProductId(userCart.getProductId());
				orderedProductDto.setQuantity(userCart.getQuantity());
				orderedProductsDto.add(orderedProductDto);
			}
			orderDto.setOrderedProducts(orderedProductsDto);

			String response = addOrder(orderDto);
			logger.info("Clearing cart..");
			cartRestClient.clearUserCart(userId);
			logger.info("DONE:Order placed!!!");
			return response;
		}
		throw new OrderNotPLacedException(ErrorCode.ORDER_NOT_PLACED);
	}

	private Boolean paymentForOrder(String userId, PaymentDetailsDto paymentDetails) {
		return paymentRestClient.pay(userId, paymentDetails);
	}

	private String addOrder(OrderDto order) {
		ResponseEntity<String> response = restTemplate.postForEntity(ORDER_BASE_URL, order, String.class);
		return response.getBody();
	}

}
