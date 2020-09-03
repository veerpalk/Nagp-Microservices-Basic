package com.nagarro.nagp.payment.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.payment.enums.PaymentMode;
import com.nagarro.nagp.payment.services.PaymentMethod;

//@Service("creditCard")
public class CreditCardPayment implements PaymentMethod {

	Logger logger = LogManager.getLogger(CreditCardPayment.class);

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardPayment(String nm, String ccNum, String cvv, String expiryDate) {
		this.name = nm;
		this.cardNumber = ccNum;
		this.cvv = cvv;
		this.dateOfExpiry = expiryDate;
	}

	@Override
	public Boolean pay(Double amount) {
		logger.info("Payment done via Credit card");

		int discount = PaymentMode.CREDIT_CARD.getDiscount();
		System.out.println("Amount" + amount + "beforeDiscount");
		amount -= amount * discount / 100;
		System.out.println(amount + " paid with credit/debit card after discount of " + discount + "%");
		return true;
	}

}
