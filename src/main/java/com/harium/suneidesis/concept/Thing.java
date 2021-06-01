package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.attribute.Attributes;

import java.util.Objects;

public class Thing {

	private Attributes attributes;

	public String getName() {
		return getAttributes().getName();
	}

	public Concept getNameConcept() {
		return getAttributes().getNameConcept();
	}

	protected void setName(String name) {
		getAttributes().setName(name);
	}

	public Attributes getAttributes() {
		if (attributes == null) {
			attributes = new Attributes();
		}
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributes);
	}
}
