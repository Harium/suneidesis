package com.harium.suneidesis.concept;


import com.harium.suneidesis.concept.numeral.Quantity;

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
		type(type);
	}

	public Concept(String name, Concept type) {
		super(name);
		type(type);
	}

	public Concept getType() {
		return attributes.get(ATTRIBUTE_TYPE);
	}

	public Concept type(Concept type) {
		attributes.set(ATTRIBUTE_TYPE, type);
		return this;
	}

	public Concept is(Concept concept) {
		this.attributes.is(concept);
		return this;
	}

	public Concept can(Action action) {
		this.attributes.can(action);
		return this;
	}

	public Concept has(Concept property, Quantity quantity) {
		this.attributes.has(property, quantity);
		return this;
	}

	public Concept hasNo(Concept property) {
		this.attributes.has(property, Quantity.ZERO);
		return this;
	}

	public void set(String key, Concept property) {
		this.attributes.set(key, property);
	}

	public Concept get(String key) {
		this.attributes.get(key);
		return this;
	}

	public Concept isLocatedAt(Place place) {
		this.attributes.isLocatedAt(place);
		return this;
	}

	public Concept isLocatedAt(String placeName) {
		return this.isLocatedAt(new Place(placeName));
	}

}
