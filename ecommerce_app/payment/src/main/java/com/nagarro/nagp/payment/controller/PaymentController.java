package com.nagarro.nagp.payment.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.payment.dtos.PaymentDetailsDTO;
import com.nagarro.nagp.payment.enums.PaymentMode;
import com.nagarro.nagp.payment.services.PaymentMethod;
import com.nagarro.nagp.payment.services.PaymentService;
import com.nagarro.nagp.payment.services.impl.CashOnDeliveryPayment;
import com.nagarro.nagp.payment.services.impl.CreditCardPayment;
import com.nagarro.nagp.payment.services.impl.PaytmPayment;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	Logger logger = LogManager.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("")
	public Boolean pay(@RequestParam String userId, @RequestBody PaymentDetailsDTO paymentDetails) {

		return paymentService.payOrder(userId, paymentDetails);

	}
}
