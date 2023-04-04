package com.films4you.req2;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.films4you.main.Database;

public class PaymentManager /*implements Comparator<Payment> */{
		
	List<Payment> payments;
	
	public PaymentManager() {
		this.payments = new ArrayList<Payment>();
		initialisePayments();
	}

	private void initialisePayments() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM payment");
		try {
			int i;
			BigDecimal amount;
			while (queryresult.next()) {
				i = findCustomer(queryresult.getInt("customer_id"));
				amount = queryresult.getBigDecimal("amount");
				System.out.println(amount);
				if (i > -1) {
					payments.get(i).addPayment(amount);
				} else {
					payments.add(new Payment(queryresult.getInt("customer_id"), amount));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void sortArrayDescending() {
		Collections.sort(payments, new Comparator<Payment>() {
			public int compare(Payment o1, Payment o2) {
				return o1.getTotalAmount().compareTo(o2.getTotalAmount());
			}
		});
		Collections.reverse(payments);
	}
	
	private int findCustomer(int ID) {
		for (Payment p : payments) {
			if (p.getID() == ID) {
				return payments.indexOf(p);
			}
		}
		return -1;
	}
	
//	public String printArray(List<Payment> a) {
//		for (Payment p : a) {
//			System.out.println("ID: " + p.getID() + ", total payments: " + p.getTotalAmount());
//		}
//		return "";
//	}
	
	public List<Payment> getTopTen() {
		return payments.subList(0, 10);
		//returns array with top ten ids and payments
	}

	//TODO commented code remove
//	@Override
//	public int compare(Payment o1, Payment o2) {
//		return o1.getTotalAmount().compareTo(o2.getTotalAmount());
//	}
	
}
