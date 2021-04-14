package com.harium.suneidesis.concept.word;

public class WordDeterminer extends Word {

	public static final String ATTRIBUTE_GENDER = "gender";

	public WordDeterminer(String name) {
		super(name, Word.TAG_DETERMINER);
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

}
