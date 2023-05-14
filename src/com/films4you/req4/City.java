package com.films4you.req4;

import java.math.BigDecimal;

/**
 * Object representing a city in the database, with a field containing its total revenue produced
 * @author gpotts
 *
 */
public class City implements Comparable<City>{

	private int cityID;
	private BigDecimal revenue;
	private String name;

	public City(int id, BigDecimal amount) {
		if (id < 0) {
			throw new IllegalArgumentException("id number must be positive");
		}
		
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("revenue must be positive");
		}
		
		this.cityID = id;
		this.revenue = amount;
		this.name = "unknown name";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getRevenue() {
		return revenue;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(City o) {
		return revenue.compareTo(o.getRevenue());
	}
}
