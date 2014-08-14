package com.medievalperson;

import com.medievalperson.concept.ConceptType;


public class Concept {

	protected String name;
	
	protected ConceptType type = ConceptType.UNKNOWN;
	
	public Concept(String name) {
		super();		
		this.name = name;
	}
	
	public Concept(String name, ConceptType type) {
		super();		
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
