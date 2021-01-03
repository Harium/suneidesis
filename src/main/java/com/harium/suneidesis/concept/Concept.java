package com.harium.suneidesis.concept;


public class Concept extends Thing {

	public static final String ATTRIBUTE_TYPE = "type";

	public static final Concept UNKNOWN = new Concept(ConceptType.UNKNOWN);

	public Concept() {
		super();
	}

	public Concept(String name) {
		super(name);
	}

	public Concept(Concept type) {
		super();
		setType(type);
	}

	public Concept(String name, Concept type) {
		super(name);
		setType(type);
	}

	public Concept getType() {
		return attributes.get(ATTRIBUTE_TYPE);
	}

	public void setType(Concept type) {
		attributes.set(ATTRIBUTE_TYPE, type);
	}
}
