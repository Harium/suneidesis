package com.medievalperson.knowledge;

import com.medievalperson.beign.Being;
import com.medievalperson.beign.HealthStatus;
import com.medievalperson.knowledge.feeling.FeelingParser;

public class SimpleFeelingParser implements FeelingParser {

	private int fineInterval = 90;
	
	private int goodInterval = 75;
	
	private int badInterval = 50;
	
	@Override
	public String parse(String query, Being beign) {

		if(query.contains("You")){
			return "I am "+translateFeelingToString(beign.getHealthStatus())+".";
		}
		
		return null;
		
	}
		
	public String translateFeelingToString(HealthStatus feeling){
		
		int health = feeling.getHealth();
		
		String state = "";
		
		if(health>=fineInterval){
			state = "Fine";
		}else if(health>=goodInterval){
			state = "Good";
		}else if(health<badInterval){
			state = "Bad";
		}
		
		return state;
		
	}
	
}
