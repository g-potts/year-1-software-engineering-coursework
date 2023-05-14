package com.films4you.req2;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;
//import com.films4you.main.TaskNotAttemptedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Requirement 2: list the top 10 customers by revenue.
 * 
 * @author Grace Potts
 *
 */
public class Requirement implements RequirementInterface {
	
	/**
	 * creates arraylist of strings containing name and revenue of top 10 customers.
	 * @return ArrayList containing top ten customers by revenue.
	 */
	private List<String> findTopTenInfo(){
		PaymentManager pm = new PaymentManager();
		pm.sortArrayDescending();
		List<Customer> toptenlist = pm.getTopTen();
		List<String> topteninfo = new ArrayList<String>();
		
		Database db = new Database();		
		for (Customer p : toptenlist) {
			int id = p.getID();
			try {
				ResultSet queryresult = db.query("SELECT * FROM customer");
				while (id != queryresult.getInt("customer_id")) {
					queryresult.next();
				}
				topteninfo.add(queryresult.getString("first_name") + " " + queryresult.getString("last_name") + "," + p.getTotalAmount());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		db.close();
		return topteninfo;
	}
	
	@Override
	public @Nullable String getValueAsString() {
		String output = "";
		for (String s : findTopTenInfo()) {
			output += s + "\n";
		}
		return output;
	}

	@Override
	public @NonNull String getHumanReadable() {
		String output = "";
		int i = 1;
		for (String s : findTopTenInfo()) {
			output += ("The number " + i + " customer is " + s.split(",")[0] +
					" who generated £" + s.split(",")[1] + " of income.\n");
			i++;
		}
		return output;
	}

}
