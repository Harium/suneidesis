package com.harium.suneidesis.concept;


import com.harium.suneidesis.concept.numeral.Measure;
import com.harium.suneidesis.concept.primitive.Text;

public class Concept extends Thing {

	public static final String ATTRIBUTE_ID = "id";
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

	public String getIdText() {
		return getId().getName();
	}

	public Concept getId() {
		return attributes.get(ATTRIBUTE_ID);
	}

	public Concept id(String id) {
		attributes.set(ATTRIBUTE_ID, new Text(id));
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

	public boolean hasKey(String key) {
		return !get(key).isUnknown();
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
