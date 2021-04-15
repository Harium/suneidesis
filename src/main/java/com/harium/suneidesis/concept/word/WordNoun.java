package com.harium.suneidesis.concept.word;

public class WordNoun extends Word {

	private static final String ATTRIBUTE_GENDER = "gender";

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
		attributes.insert(ATTRIBUTE_GENDER, gender);
	}

}
