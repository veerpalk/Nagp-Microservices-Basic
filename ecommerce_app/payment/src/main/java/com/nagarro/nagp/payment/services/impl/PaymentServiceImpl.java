package com.nagarro.nagp.payment.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.payment.controller.PaymentController;
import com.nagarro.nagp.payment.dtos.PaymentDetailsDTO;
import com.nagarro.nagp.payment.enums.ErrorCode;
import com.nagarro.nagp.payment.enums.PaymentMode;
import com.nagarro.nagp.payment.exceptions.PaymentTypeNotSupportedException;
import com.nagarro.nagp.payment.services.PaymentMethod;
import com.nagarro.nagp.payment.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	Logger logger = LogManager.getLogger(PaymentController.class);
	private PaymentMethod paymentMethod;



	@Override
	public Boolean payOrder(String userId, PaymentDetailsDTO paymentDetails) {
		logger.info("Making payment with mode {}", paymentDetails.getPaymentMode());
		
		validatePaymentDetails(paymentDetails);
		
		if(paymentDetails.getPaymentMode().toUpperCase().equals(PaymentMode.PAYTM.name()))
			this.paymentMethod=new PaytmPayment(paymentDetails.getPhoneNumber(), paymentDetails.getPassword());
		
		else if(paymentDetails.getPaymentMode().toUpperCase().equals(PaymentMode.CREDIT_CARD.name()))
			this.paymentMethod=new CreditCardPayment(paymentDetails.getName(),paymentDetails.getCardNumber(), paymentDetails.getCvv(),paymentDetails.getDateOfExpiry());
		else
			this.paymentMethod=new CashOnDeliveryPayment();
		
		Boolean isPaymentSuccessful=paymentMethod.pay(paymentDetails.getAmount());
		return isPaymentSuccessful;
	}
	
	private void validatePaymentDetails(PaymentDetailsDTO paymentDetails)
	{
		List<PaymentMode> paymentModeList = Arrays.asList(PaymentMode.values());
		List<PaymentMode> paymentModes = paymentModeList.stream().filter(p->p.name().equals(paymentDetails.getPaymentMode().toUpperCase())).collect(Collectors.toList());
		if(paymentModes.isEmpty())
			throw new PaymentTypeNotSupportedException(ErrorCode.PAYMENT_TYPE_NOT_SUPPORTED);
	}

}
