package com.films4you.req4;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.films4you.main.Database;

/**
 * class that processes customers within database
 * @author gpotts
 *
 */
public class CustomerManager {
	
	private Map<Integer, Customer> customers;
	
	public CustomerManager() {
		customers = new HashMap<Integer, Customer>();
	}
	
	/**
	 * adds all customers in database to hashmap
	 */
	public void initialiseCustomers() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM customer");
		int id;
		Customer c;
		try {
			while (queryresult.next()) {
				id = queryresult.getInt("customer_id");
				c = new Customer(id);
				c.setAddressID(queryresult.getInt("address_id"));
				customers.put(id, c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
	}
	
	/**
	 * adds total payments to each customer in payment
	 */
	public void addPayments() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM payment");
		int customerid;
		try {
			while (queryresult.next()) {
				customerid = queryresult.getInt("customer_id");
				customers.get(customerid).addPayment(queryresult.getBigDecimal("amount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
	}
	
	/**
	 * generates new hashmap linking customer address to their payment
	 * @return hashmap with key being address id and value being total payments at that address 
	 */
	public Map<Integer, BigDecimal> createAddressMap() {
		Map<Integer, BigDecimal> addressmap = new HashMap<Integer, BigDecimal>();
		for (int i : customers.keySet()) {
			addressmap.put(customers.get(i).getAddressID(), customers.get(i).getTotalPayments());
		}
		return addressmap;
	}
	
}
