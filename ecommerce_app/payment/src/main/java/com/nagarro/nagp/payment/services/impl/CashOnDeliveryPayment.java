package com.nagarro.nagp.payment.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.payment.controller.PaymentController;
import com.nagarro.nagp.payment.enums.PaymentMode;
import com.nagarro.nagp.payment.services.PaymentMethod;

//@Service("cashOnDelivery")
public class CashOnDeliveryPayment implements PaymentMethod {
	
	Logger logger = LogManager.getLogger(CashOnDeliveryPayment.class);


	@Override
	public Boolean pay(Double amount) {
		
		logger.info("Payment done via CASH ON DELIVERY ");
		
		int discount = PaymentMode.CASH_ON_DELIVERY.getDiscount();
		System.out.println("Amount" + amount + "beforeDiscount");
		amount -= amount * discount / 100;
		System.out.println(amount + " to be paid using Cash after discount of " + discount+"%");
		return true;
	}

}
