package com.harium.suneidesis.concept;

import com.harium.suneidesis.Thing;


public class Concept extends Thing {
	
	public static final Concept UNKNOWN = new Concept("unknown", ConceptType.UNKNOWN);
	protected ConceptType type = ConceptType.UNKNOWN;
	
	public Concept(String name) {
		super(name);
	}
	
	public Concept(String name, ConceptType type) {
		super(name);
		this.type = type;
	}

}
