package com.harium.suneidesis.concept;


import com.harium.suneidesis.concept.numeral.Measure;

public class Concept extends Thing {

	public static final String ATTRIBUTE_TYPE = "type";

	public static final Concept UNKNOWN = new Concept(ConceptType.UNKNOWN);
	public static final Concept SECRET = new Concept(ConceptType.SECRET);

	public Concept() {
		super();
	}

	public Concept(String name) {
		super();
		setName(name);
	}

	public Concept(Concept type) {
		super();
		type(type);
	}

	public Concept(Concept type, DataType dataType) {
		super();
		type(type);
		dataType(dataType);
	}

	public Concept(String name, Concept type) {
		super();
		type(type);
		setName(name);
	}

	public Concept getType() {
		return attributes.get(ATTRIBUTE_TYPE);
	}

	public Concept type(Concept type) {
		attributes.set(ATTRIBUTE_TYPE, type);
		return this;
	}

	public DataType getDataType() {
		return attributes.getDataType();
	}

	public Concept dataType(DataType dataType) {
		this.attributes.setDataType(dataType);
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
		return set(key, property);
	}

	public Concept set(String key, Concept property) {
		this.attributes.set(key, property);
		return this;
	}

	public Concept hasQuantity(Concept property, Measure measure) {
		this.attributes.hasPart(property, measure);
		return this;
	}

	public Concept hasQuantity(String property, Measure measure) {
		return hasQuantity(new Concept(property), measure);
	}

	// Maybe replace by negative modifier
	public Concept hasNoQuantity(Concept property) {
		this.attributes.hasPart(property, Measure.ZERO);
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

	public boolean isUnknown() {
		return (ConceptType.UNKNOWN.equals(getType()));
	}

	public boolean isSecret() {
		return (ConceptType.SECRET.equals(getType()));
	}
}
