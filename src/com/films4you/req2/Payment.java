package com.films4you.req2;

public class Payment /*implements Comparable<Payment>*/ {
	
	private int customerID;
	private double totalAmount;
	
	public Payment(int customerID, double amount) {
		this.customerID = customerID;
		totalAmount = amount;
	}
	
	public void addPayment(double amount) {
		totalAmount += amount;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public int getID() {
		return customerID;
	}

//	@Override
//	public int compareTo(Payment p) {
//		if (p.getTotalAmount() < this.totalAmount) {
//			return -1;
//		} else if (p.getTotalAmount() > this.totalAmount) {
//			return 1;
//		}
//		return 0;
//	}
	
}
