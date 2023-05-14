package com.films4you.req2;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.films4you.main.Database;
/**
 * Class for processing customers and their respective payments from the database.
 * @author gpott
 *
 */
public class PaymentManager {
		
	private List<Customer> customerPayments;
	
	public PaymentManager() {
		this.customerPayments = new ArrayList<Customer>();
		initialisePayments();
	}
	
	/**
	 * Sorts all payments found in database into a list of customers.
	 */
	private void initialisePayments() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM payment");
		try {
			int i;
			BigDecimal amount;
			while (queryresult.next()) {
				i = findCustomer(queryresult.getInt("customer_id"));
				amount = queryresult.getBigDecimal("amount");
				if (i > -1) {
					customerPayments.get(i).addPayment(amount);
				} else {
					customerPayments.add(new Customer(queryresult.getInt("customer_id"), amount));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
	}
	/**
	 * searches this object's list of customers for the customer with given ID
	 * @param ID ID of customer to be found
	 * @return index of customer within this object's list, or -1 if not found.
	 */
	private int findCustomer(int ID) {
		for (Customer p : customerPayments) {
			if (p.getID() == ID) {
				return customerPayments.indexOf(p);
			}
		}
		return -1;
	}
	public void sortArrayDescending() {
		Collections.sort(customerPayments, new Comparator<Customer>() {
			public int compare(Customer o1, Customer o2) {
				return o1.getTotalAmount().compareTo(o2.getTotalAmount());
			}
		});
		Collections.reverse(customerPayments);
	}
	
	public List<Customer> getTopTen() {
		return customerPayments.subList(0, 10);
	}
	
}
