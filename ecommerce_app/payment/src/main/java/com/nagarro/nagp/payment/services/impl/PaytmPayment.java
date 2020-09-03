package com.nagarro.nagp.payment.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.payment.enums.PaymentMode;
import com.nagarro.nagp.payment.services.PaymentMethod;

//@Service("paytm")
public class PaytmPayment implements PaymentMethod {
	
	Logger logger = LogManager.getLogger(PaytmPayment.class);


	private String phoneNumber;
	private String password;

	public PaytmPayment(String phoneNo, String pwd) {
		this.phoneNumber = phoneNo;
		this.password = pwd;
	}

	@Override
	public Boolean pay(Double amount) {
		
		logger.info("Payment done via Paytm ");

		int discount = PaymentMode.PAYTM.getDiscount();
		System.out.println("Amount" + amount + "beforeDiscount");
		amount -= amount * discount / 100;
		System.out.println(amount + " paid using Paytm after discount of " + discount + "%");
		return true;
	}

}
