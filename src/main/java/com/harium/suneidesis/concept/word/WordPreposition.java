package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordPreposition extends Word {

	public static final String ATTRIBUTE_USE = "use";

	public WordPreposition(String name) {
		super(name, Tag.PREPOSITION);
	}

	public Word getUse() {
		return (Word) attributes.get(ATTRIBUTE_USE);
	}

	public String getUseWord() {
		return attributes.get(ATTRIBUTE_USE).getName();
	}

	public void setUse(Word use) {
		attributes.insert(ATTRIBUTE_USE, use);
	}
}
