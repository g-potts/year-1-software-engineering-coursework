package com.films4you.req2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.films4you.main.Database;

public class PaymentManager implements Comparator<Payment>{
	
	//fields
	
	List<Payment> payments;
	
	//constructor
	public PaymentManager() {
		this.payments = new ArrayList<Payment>();
		initialisePayments();
	}
	//methods
	private void initialisePayments() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM payment");
		try {
			int i;
			while (queryresult.next()) {
				//if list does not contain item with this custID, make a new one
				//add current amount to item with this custID
				i = findCustomer(queryresult.getInt("customer_id"));
				if (i > -1) {
					payments.get(i).addPayment(queryresult.getDouble("amount"));
				} else {
					payments.add(new Payment(queryresult.getInt("customer_id"), queryresult.getDouble("amount")));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		payments.sort(null);
	}
	
	private int findCustomer(int ID) {
		for (Payment p : payments) {
			if (p.getID() == ID) {
				return payments.indexOf(p);
			}
		}
		return -1;
	}
	@Override
	public int compare(Payment p1, Payment p2) {
		if (p1.getTotalAmount() < p2.getTotalAmount()) {
			return -1;
		} else if (p1.getTotalAmount() > p2.getTotalAmount()) {
			return 1;
		}
		return 0;
	}
	
}
