package com.harium.suneidesis.concept.word;

public class WordPreposition extends Word {

	public static final String ATTRIBUTE_USE = "use";
	public static final String ATTRIBUTE_TYPE = "type";

	public WordPreposition(String name) {
		super(name, Word.TAG_PREPOSITION);
	}

	public Word getType() {
		return (Word) attributes.get(ATTRIBUTE_TYPE);
	}

	public String getTypeWord() {
		return getType().getName();
	}

	public void setType(Word Type) {
		attributes.set(ATTRIBUTE_TYPE, Type);
	}

	public Word getUse() {
		return (Word) attributes.get(ATTRIBUTE_USE);
	}

	public String getUseWord() {
		return attributes.get(ATTRIBUTE_USE).getName();
	}

	public void setUse(Word use) {
		attributes.set(ATTRIBUTE_USE, use);
	}
}
