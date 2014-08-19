package com.suneidesis.answer;

import com.suneidesis.adjectives.Adjective;
import com.suneidesis.answer.adjective.AdjectiveParser;
import com.suneidesis.beign.Being;

public class SimpleAdjectiveParser implements AdjectiveParser {

	@Override
	public String parse(String query, Being beign) {
		
		String[] parts = query.replaceAll("\\?", "").split(" ");
		
		String adjectiveQuery = parts[2];
		
		if(query.contains("you")) {
						
			for(Adjective adjective: beign.getAdjectives()) {
				
				if(adjective.getName().equalsIgnoreCase(adjectiveQuery)) {
			
					return "Yes, I am "+adjectiveQuery+".";
					
				}
				
			}
			
			return "No, I am not "+adjectiveQuery+".";
			
		}
		
		return null;
		
	}
	
}
