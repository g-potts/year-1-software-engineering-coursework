package com.films4you.req2;

import java.math.BigDecimal;

public class Payment implements Comparable<Payment> {
	
	private int customerID;
	private BigDecimal totalAmount;
	
	public Payment(int customerID, BigDecimal initialamount) {
		if (customerID < 0) {
			throw new IllegalArgumentException("invalid customer id, must be positive integer");
		}
		if (initialamount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("cannot begin with negative payments");
		}
		this.customerID = customerID;
		totalAmount = initialamount;
	}
	
	public void addPayment(BigDecimal amount) {
		//TODO [[done]] check positive bigdecimal
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("Can only add positive payment amounts");
		}
		totalAmount = totalAmount.add(amount);
	}
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	public int getID() {
		return customerID;
	}
	
	@Override
	public int compareTo(Payment p) {

		return p.getTotalAmount().compareTo(this.totalAmount);
	}
	
}
