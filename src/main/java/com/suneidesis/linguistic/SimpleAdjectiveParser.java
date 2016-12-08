package com.suneidesis.linguistic;

import com.suneidesis.adjectives.Adjective;
import com.suneidesis.beign.Being;
import com.suneidesis.linguistic.adjective.AdjectiveParser;

public class SimpleAdjectiveParser implements AdjectiveParser {

	private static final String YOU = "you"; 
	
	@Override
	public String parse(String query, Being beign) {
		
		String[] parts = query.replaceAll("\\?", "").split(" ");
		
		String adjectiveQuery = parts[2];
		
		if(query.contains(YOU)) {
						
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
