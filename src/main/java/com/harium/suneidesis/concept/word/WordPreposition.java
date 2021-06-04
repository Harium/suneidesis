package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordPreposition extends Word {

	public static final String ATTRIBUTE_USE = "use";

	public WordPreposition(String name) {
		super(name, Tag.PREPOSITION);
	}

	public Word getUse() {
		return (Word) getAttributes().get(ATTRIBUTE_USE);
	}

	public String getUseWord() {
		return getAttributes().get(ATTRIBUTE_USE).getName();
	}

	public void setUse(Word use) {
		getAttributes().add(ATTRIBUTE_USE, use);
	}

	@Override
	public WordPreposition wrap(Concept concept) {
		super.wrap(concept);
		return this;
	}

}
