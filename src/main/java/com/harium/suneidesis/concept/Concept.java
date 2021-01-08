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

	public Concept has(String key, Concept property) {
		this.attributes.set(key, property);
		return this;
	}

	public Concept hasPart(Concept property, Quantity quantity) {
		this.attributes.hasPart(property, quantity);
		return this;
	}

	public Concept hasPart(String property, Quantity quantity) {
		return hasPart(new Concept(property), quantity);
	}

	public Concept hasNo(Concept property) {
		this.attributes.hasPart(property, Quantity.ZERO);
		return this;
	}

	public Concept get(String key) {
		return this.attributes.get(key);
	}

	public Concept isLocatedAt(Place place) {
		this.attributes.isLocatedAt(place);
		return this;
	}

	public Concept isLocatedAt(String placeName) {
		return this.isLocatedAt(new Place(placeName));
	}

}
