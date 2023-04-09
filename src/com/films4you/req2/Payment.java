package com.films4you.req2;

import java.math.BigDecimal;

public class Payment implements Comparable<Payment> {
	
	private int customerID;
	private BigDecimal totalAmount;
	
	public Payment(int customerID, BigDecimal amount) {
		this.customerID = customerID;
		totalAmount = amount;
	}
	
	public void addPayment(BigDecimal amount) {
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
//		if (p.getTotalAmount() < this.totalAmount) {
//			return -1;
//		} else if (p.getTotalAmount() > this.totalAmount) {
//			return 1;
//		}
//		return 0;
		return p.getTotalAmount().compareTo(this.totalAmount);
	}
	
}
