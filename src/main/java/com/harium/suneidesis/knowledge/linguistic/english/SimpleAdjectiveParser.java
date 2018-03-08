package com.harium.suneidesis.knowledge.linguistic.english;

import com.harium.suneidesis.knowledge.concept.Adjective;
import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.linguistic.core.adjective.AdjectiveParser;

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
