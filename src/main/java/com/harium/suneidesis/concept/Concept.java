package com.harium.suneidesis.concept;


public class Concept extends Thing {
	
	public static final Concept UNKNOWN = new Concept("unknown", ConceptType.UNKNOWN);
	protected ConceptType type = ConceptType.UNKNOWN;
	
	public Concept(String name) {
		super(name);
	}

	public Concept() {
		super();
	}

	public Concept(ConceptType type) {
		super(type.name());
		this.type = type;
	}

	public Concept(String name, ConceptType type) {
		super(name);
		this.type = type;
	}

	public ConceptType getType() {
		return type;
	}

	public void setType(ConceptType type) {
		this.type = type;
	}
}
