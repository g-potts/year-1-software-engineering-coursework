package com.films4you.req4;

import java.math.BigDecimal;

/**
 * Class that represents one customer within the database.
 * @author gpott
 *
 */
public class Customer {
	
	private int customerID;
	private int addressID;
	private BigDecimal totalpayments;
	
	public Customer(int customerID) {
		if (customerID < 0) {
			throw new IllegalArgumentException("customer ID must be positive");
		}
		this.customerID = customerID;
		this.totalpayments = BigDecimal.ZERO;
	}
	
	/**
	 * Increases total payments recorded by value given.
	 * @param amount value of payment to be added, must be positive
	 */
	public void addPayment(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("amount must be positive");
		}
		totalpayments = totalpayments.add(amount);
	}
	
	public void setAddressID(int addressID) {
		if (addressID < 0) {
			throw new IllegalArgumentException("address ID must be positive integer");
		}
		this.addressID = addressID;
	}
	
	public int getAddressID() {
		return addressID;
	}
	
	public BigDecimal getTotalPayments() {
		return totalpayments;
	}
	
}
