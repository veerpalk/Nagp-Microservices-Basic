package com.nagarro.nagp.payment.services;

import org.springframework.stereotype.Service;

import com.nagarro.nagp.payment.dtos.PaymentDetailsDTO;

@Service
public interface PaymentService {
	
	public Boolean payOrder(String userId,PaymentDetailsDTO paymentDetails);


}
