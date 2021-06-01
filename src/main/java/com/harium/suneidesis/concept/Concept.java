package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.word.Word;

import java.util.Map;

public class Concept extends Thing {

	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_TYPE = "type";

	private String id;

	public Concept(String name) {
		super();
		setName(name);
	}

	public Concept(ConceptType type) {
		super();
		type(type);
	}

	public Concept(String name, ConceptType type) {
		super();
		type(type);
		setName(name);
	}

	public Concept(String name, ConceptType type, DataType dataType) {
		this(name, type);
		dataType(dataType);
	}

	public String getValue() {
		return getName();
	}

	public Concept getType() {
		return getAttributes().get(ATTRIBUTE_TYPE);
	}

	public Concept type(Concept type) {
		getAttributes().insert(ATTRIBUTE_TYPE, type);
		return this;
	}

	public String getId() {
		return id;
	}

	public Concept getIdConcept() {
		return getAttributes().get(ATTRIBUTE_ID);
	}

	public Concept id(String id) {
		this.id = id;
		getAttributes().insert(ATTRIBUTE_ID, new Word(id));
		return this;
	}

	public DataType getDataType() {
		return getAttributes().getDataType();
	}

	public Concept dataType(DataType dataType) {
		this.getAttributes().setDataType(dataType);
		return this;
	}

	public Concept is(Concept concept) {
		this.getAttributes().is(concept);
		return this;
	}

	public Concept can(Action action) {
		this.getAttributes().can(action);
		return this;
	}

	public Concept has(String key, Concept property) {
		return set(key, property);
	}

	public boolean hasKey(String key) {
		return this.getAttributes().contains(key);
	}

	public Concept set(String key, Concept property) {
		this.getAttributes().insert(key, property);
		return this;
	}

	public Concept hasQuantity(Concept property, Measurement measurement) {
		this.getAttributes().hasPart(property, measurement);
		return this;
	}

	public Concept hasQuantity(String property, Measurement measurement) {
		return hasQuantity(new Concept(property), measurement);
	}

	public Concept hasNoQuantity(Concept property) {
		return hasQuantity(property, Measurement.ZERO);
	}

	public Concept hasNoQuantity(String property) {
		return hasNoQuantity(new Concept(property));
	}

	public Concept get(String key) {
		return this.getAttributes().get(key);
	}

	public Concept isLocatedAt(Place place) {
		this.getAttributes().isLocatedAt(place);
		return this;
	}

	public Concept isLocatedAt(String placeName) {
		return this.isLocatedAt(new Place(placeName));
	}

	public boolean isUnknown() {
		return ConceptType.UNKNOWN_TYPE.equals(getType());
	}

	public boolean isSecret() {
		return ConceptType.SECRET_TYPE.equals(getType());
	}

	public boolean isPrimitive() {
		return DataType.PRIMITIVE.equals(getDataType());
	}

	public Map<String, Concept> getMap() {
		return getAttributes().getAll();
	}

	public Concept wrap(Concept concept) {
		setName(concept.getName());
		setAttributes(concept.getAttributes());
		return this;
	}

}
