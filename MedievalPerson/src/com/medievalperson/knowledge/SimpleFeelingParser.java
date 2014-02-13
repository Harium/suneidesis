package com.medievalperson.knowledge;

import com.medievalperson.beign.Beign;
import com.medievalperson.beign.Feeling;
import com.medievalperson.knowledge.feeling.FeelingParser;

public class SimpleFeelingParser implements FeelingParser {

	private int fineInterval = 90;
	
	private int goodInterval = 75;
	
	private int badInterval = 50;
	
	@Override
	public String parse(String query, Beign beign) {

		if(query.contains("You")){
			return "I am "+translateFeelingToString(beign.getFeeling())+".";
		}
		
		return null;
		
	}
		
	public String translateFeelingToString(Feeling feeling){
		
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
