package com.films4you.req2;

import java.math.BigDecimal;

/**
 * Represents a customer and their total payments to Films4You.
 * 
 * @author Grace Potts
 *
 */
public class Customer implements Comparable<Customer> {
	
	private int customerID;
	private BigDecimal totalAmount;
	
	public Customer(int customerID, BigDecimal initialamount) {
		if (customerID < 0) {
			throw new IllegalArgumentException("invalid customer id, must be positive integer");
		}
		if (initialamount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("cannot begin with negative payments");
		}
		
		this.customerID = customerID;
		totalAmount = initialamount;
	}
	/**
	 * Increases total payments recorded by value given.
	 * @param amount value of payment to be added, must be positive
	 */
	public void addPayment(BigDecimal amount) {
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
	public int compareTo(Customer p) {
		return p.getTotalAmount().compareTo(this.totalAmount);
	}
	
}
