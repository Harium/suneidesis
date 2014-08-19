package com.suneidesis.concept;

import com.suneidesis.Thing;


public class Concept extends Thing {
	
	protected ConceptType type = ConceptType.UNKNOWN;
	
	public Concept(String name) {
		super(name);
	}
	
	public Concept(String name, ConceptType type) {
		super(name);
		this.type = type;
	}

}
