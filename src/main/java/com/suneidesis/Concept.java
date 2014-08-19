package com.suneidesis;

import com.suneidesis.concept.ConceptType;


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
