package com.nagarro.nagp.payment.enums;

public enum PaymentMode {
	CASH_ON_DELIVERY("cashOnDelivery", 0), CREDIT_CARD("creditCard", 10), PAYTM("paytm", 5);

	private String paymentType;
	private int discount;

	private PaymentMode(String paymentType, int discount) {
		this.paymentType = paymentType;
		this.discount = discount;
	}

	public String getpaymentType() {
		return this.paymentType;
	}

	public int getDiscount() {
		return this.discount;
	}

}
