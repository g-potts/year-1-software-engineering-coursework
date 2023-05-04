package com.films4you.req3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.films4you.main.Database;
public class RentalCounter {

	List<Customer> customers;

	public RentalCounter() {
		this.customers = new ArrayList<Customer>();
	}

	public void initialiseArray() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM customer");
		String fullname = "";
		try {
			while (queryresult.next()) {
				fullname = (queryresult.getString("first_name") + " "
						+ queryresult.getString("last_name"));
				customers.add(new Customer(fullname,
						queryresult.getInt("customer_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void countRentals() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM rental");
		try {
			int i = -1;
			while (queryresult.next()) {
				i = findCustomer(queryresult.getInt("customer_id"));
				if (i == -1) {
					throw new NullPointerException("customer not initialised");
				} else {
					customers.get(i).addRental();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int findCustomer(int ID) {
		for (Customer c : customers) {
			if (c.getID() == ID) {
				return customers.indexOf(c);
			}
		}
		return -1;
	}

	public void sortByRentalsDescending() {
		Collections.sort(customers, new Comparator<Customer>() {
			public int compare(Customer o1, Customer o2) {
				return Integer.compare(o1.getRentals(), o2.getRentals());
			}
		});
		Collections.reverse(customers);
	}

	public Customer getRenter(int index) {
		return customers.get(index);
	}

}
