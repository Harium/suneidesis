package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.word.Word;

import java.util.Objects;

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
		return attributes.getNameWord();
	}

	public Word getNameConcept() {
		return attributes.getName();
	}

	public void setName(String name) {
		attributes.setName(name);
	}

	public void setNameWord(Word name) {
		attributes.setNameWord(name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, attributes);
	}
}
