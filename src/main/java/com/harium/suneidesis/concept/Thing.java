package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.attribute.Attributes;

import java.util.Objects;

public class Thing {

	protected final Attributes attributes = new Attributes();

	protected Thing() {
		super();
	}

	public Thing(String name) {
		this();
		setName(name);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String getName() {
		return attributes.getNameWord();
	}

	public void setName(String name) {
		attributes.setName(name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributes);
	}
}
