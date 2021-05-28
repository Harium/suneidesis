package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.attribute.Attributes;

import java.util.Objects;

public class Thing {

	protected final Attributes attributes = new Attributes();

	protected Thing() {
		super();
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String getName() {
		return attributes.getName();
	}

	public Concept getNameConcept() {
		return attributes.getNameConcept();
	}

	public void setName(String name) {
		attributes.setName(name);
	}

	public void setNameConcept(Concept nameConcept) {
		attributes.setNameConcept(nameConcept);
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributes);
	}
}
