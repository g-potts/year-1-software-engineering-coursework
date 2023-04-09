package com.films4you.req3;

public class Customer implements Comparable<Customer>{
	
	private String fullname;
	private int customerID;
	private int rentals;
	
	public Customer(String fullname, int customerID) {
		this.fullname = fullname;
		this.customerID = customerID;
		this.rentals = 0;
	}
	
	public void addRental() {
		rentals++;
	}
	
	public int getID() {
		return this.customerID;
	}

	@Override
	public int compareTo(Customer o) {
		return Integer.compare(rentals, o.getRentals());
	}
	
	public String getFullName() {
		return fullname;
	}
	
	public int getRentals() {
		return rentals;
	}
}
