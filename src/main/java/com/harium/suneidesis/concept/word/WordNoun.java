package com.harium.suneidesis.concept.word;

public class WordNoun extends Word {

	private static final String ATTRIBUTE_GENDER = "gender";
	private static final String ATTRIBUTE_WORD_TYPE = "word_type";

	public static final Word GENDER_MASCULINE = new Word("masculine");
	public static final Word GENDER_FEMININE = new Word("feminine");
	public static final Word GENDER_NEUTRAL = new Word("neutral");

	public WordNoun(String name) {
		super(name, Word.TAG_NOUN);
	}
	
	public Word getGender() {
		return (Word) attributes.get(ATTRIBUTE_GENDER);
	}

	public String getGenderWord() {
		return attributes.get(ATTRIBUTE_GENDER).getName();
	}

	public void setGender(Word gender) {
		attributes.set(ATTRIBUTE_GENDER, gender);
	}

	public Word getWordType() {
		return (Word) attributes.get(ATTRIBUTE_WORD_TYPE);
	}

	public String getTypeWord() {
		return getType().getName();
	}

	public void setType(Word Type) {
		attributes.set(ATTRIBUTE_WORD_TYPE, Type);
	}
}
