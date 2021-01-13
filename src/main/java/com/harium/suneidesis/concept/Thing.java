package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.generator.BaseIdGenerator;
import com.harium.suneidesis.generator.IdGenerator;

import java.util.Objects;

public class Thing {

	//private static IdGenerator idGenerator = new BaseIdGenerator();

	//protected String id;

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

	public Word getNameConcept() {
		return attributes.getName();
	}

	public void setName(String name) {
		attributes.setName(name);
	}

	public void setNameWord(Word name) {
		attributes.setNameWord(name);
	}

	/*public static void setIdGenerator(IdGenerator idGenerator) {
		Thing.idGenerator = idGenerator;
	}*/

	@Override
	public int hashCode() {
		return Objects.hash(attributes);
	}
}
