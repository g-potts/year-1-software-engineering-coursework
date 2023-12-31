package com.films4you.req3;
/**
 * Class that represents one customer within the database, and stores the total number of rentals they make.
 * @author gpott
 *
 */
public class Customer implements Comparable<Customer>{
	
	private String fullname;
	private int customerID;
	private int rentals;
	
	public Customer(String fullname, int customerID) {
		if (!fullname.matches("[A-Za-z]+ [A-Za-z]+")) {
			throw new IllegalArgumentException("invalid format for full name");
		}
		if (customerID < 0) {
			throw new IllegalArgumentException("customer ID must be greater than or equal to 0");
		}
		this.fullname = fullname;
		this.customerID = customerID;
		this.rentals = 0;
	}
	/**
	 * increments number of rentals made by one.
	 */
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
