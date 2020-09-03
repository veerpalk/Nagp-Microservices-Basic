package com.nagarro.nagp.account.restclients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nagarro.nagp.account.dtos.PaymentDetailsDto;

@Service
public class PaymentRestClient {

	Logger logger = LogManager.getLogger(PaymentRestClient.class);

	@Autowired
	private RestTemplate restTemplate;

	public final String PAYMENT_BASE_URL = "http://payment/payment";

	@GetMapping
	public Boolean pay(String userId, PaymentDetailsDto paymentDetails) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(PAYMENT_BASE_URL).queryParam("userId",
				userId);

		logger.info("Calling paymnet restClient for user:{} with paymentdetails: {} with url:{} ", userId,
				paymentDetails, builder.buildAndExpand().toUri());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// set your entity to send
		HttpEntity<PaymentDetailsDto> entity = new HttpEntity<PaymentDetailsDto>(paymentDetails, headers);

		ResponseEntity<Boolean> response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.POST,
				entity, Boolean.class);

		return response.getBody();
	}
}
