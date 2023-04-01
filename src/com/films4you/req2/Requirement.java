package com.films4you.req2;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;
import com.films4you.main.TaskNotAttemptedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Your class description here.
 * 
 * @author Your name
 *
 */
// 2. List top 10 customers by revenue.
public class Requirement implements RequirementInterface {
	
	//add them all to hashmap sort and return
	private HashMap<Integer, Double> sortMapByValue(HashMap<Integer, Double> map){
		
	}
	private ??? findTopTen(){
		
		
	}
	
	@Override
	public @Nullable String getValueAsString() {
		return findTopTen();
	}

	@Override
	public @NonNull String getHumanReadable() {
		throw new TaskNotAttemptedException();
	}

}
