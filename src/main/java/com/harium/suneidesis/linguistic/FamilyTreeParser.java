package com.harium.suneidesis.linguistic;

import com.harium.suneidesis.beign.Being;

public class FamilyTreeParser implements Parser {

	@Override
	public String parse(String query, Being beign) {
		
		String[] parts = query.replaceAll("\\?", "").split(" ");
		
		String relationship = parts[parts.length-1];
		
		String name = "";
		
		if("father".equalsIgnoreCase(relationship)){
			name = findFather(beign);
		}
		
		if("mother".equalsIgnoreCase(relationship)){
			name = findMother(beign);
		}

		if(name.isEmpty()){
			name = "I don't know";
		}
		return name;
	}
	
	private String findFather(Being beign){
		
		Being father = beign.getBiologicalFather(); 
		
		if(father!=null){
			return father.getName(); 
		}
		
		return "";		
	}
	
	private String findMother(Being beign){
		
		Being mother = beign.getBiologicalMother(); 
		
		if(mother!=null){
			return mother.getName(); 
		}
		
		return "";				
	}

}
