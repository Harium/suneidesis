package com.medievalperson.knowledge;

import com.medievalperson.beign.Beign;
import com.medievalperson.beign.Feeling;

public class SimpleParser implements Parser{
		
	private FamilyTreeParser familyTreeParser = new FamilyTreeParser();
	
	public SimpleParser() {
		super();
	}

	@Override
	public String parse(String query, Beign beign) {
		
		String[] parts = query.replaceAll("\\?", "").split(" ");
		
		if("How".equalsIgnoreCase(parts[0])&&query.contains("You")){
			return "I am "+translateFeelingToString(beign.getFeeling());
		}else if("Who".equalsIgnoreCase(parts[0])){
			
			String relationship = parts[parts.length-1];
			
			return familyTreeParser.parse(relationship, beign);
		}
		
		return "...";
	}

	private int fineInterval = 90;
	
	private int goodInterval = 75;
	
	private int badInterval = 50;
	
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
