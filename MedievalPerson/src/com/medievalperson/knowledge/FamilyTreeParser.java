package com.medievalperson.knowledge;

import com.medievalperson.beign.Beign;

public class FamilyTreeParser implements Parser {

	@Override
	public String parse(String query, Beign beign) {
		
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
	
	private String findFather(Beign beign){
		
		Beign father = beign.getBiologicalFather(); 
		
		if(father!=null){
			return father.getName(); 
		}
		
		return "";		
	}
	
	private String findMother(Beign beign){
		
		Beign mother = beign.getBiologicalMother(); 
		
		if(mother!=null){
			return mother.getName(); 
		}
		
		return "";				
	}

}
