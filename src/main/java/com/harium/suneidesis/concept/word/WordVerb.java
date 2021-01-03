package com.harium.suneidesis.concept.word;

public class WordVerb extends Word {

	// The same verb may have none or more than one
	// E.g: to,from,of,X <- None
	// TODO change to list of concepts instead
	public static final String ATTRIBUTE_PREPOSITIONS = "prepositions";
	public static final String ATTRIBUTE_TRANSITIVITY = "transitivity";

	public WordVerb(String name) {
		super(name, Word.TAG_VERB);
	}
	
	public Word getPrepositions() {
		return (Word) attributes.get(ATTRIBUTE_PREPOSITIONS);
	}

	public String getPrepositionsWord() {
		return attributes.get(ATTRIBUTE_PREPOSITIONS).getName();
	}

	public void setPrepositions(Word gender) {
		attributes.set(ATTRIBUTE_PREPOSITIONS, gender);
	}

	public Word getTransitivity() {
		return (Word) attributes.get(ATTRIBUTE_TRANSITIVITY);
	}

	public String getTransitivityWord() {
		return getTransitivity().getName();
	}

	public void setTransitivity(Word Transitivity) {
		attributes.set(ATTRIBUTE_TRANSITIVITY, Transitivity);
	}
}
