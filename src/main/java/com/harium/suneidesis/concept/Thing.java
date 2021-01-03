package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.numeral.Numeral;

public class Thing {

	private static long currentId = 0;

	protected String id;

	protected final Attributes attributes = new Attributes();

	protected Thing() {
		super();
		this.id = generateId();
	}

	public Thing(String name) {
		this();
		setName(name);
	}

	private String generateId() {
		return Long.toString(currentId++);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String getName() {
		return attributes.getName();
	}

	public void setName(String name) {
		attributes.setName(name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void can(Action action) {
		this.attributes.can(action);
	}

	public void has(Concept property, Numeral numeral) {
		this.attributes.has(property, numeral);
	}

	public void set(String key, Concept property) {
		this.attributes.set(key, property);
	}

	public void isLocatedAt(Place place) {
		this.attributes.isLocatedAt(place);
	}

	public void isLocatedAt(String placeName) {
		this.attributes.isLocatedAt(new Place(placeName));
	}

}
