package com.harium.suneidesis.concept.word;

public class WordAdjective extends Word {

	public static final String ATTRIBUTE_GENDER = "gender";

	public WordAdjective(String name) {
		super(name, Word.TAG_ADJECTIVE);
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
