package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordVerb extends Word {

	// The same verb may have none or more than one
	// E.g: to,from,of,X <- None
	// TODO change to list of concepts instead
	public static final String ATTRIBUTE_PREPOSITIONS = "prepositions";
	public static final String ATTRIBUTE_REGULARITY = "regularity";
	public static final String ATTRIBUTE_TRANSITIVITY = "transitivity";

	public WordVerb(String name) {
		super(name, Tag.VERB);
	}
	
	public Word getPrepositions() {
		return (Word) getAttributes().get(ATTRIBUTE_PREPOSITIONS);
	}

	public String getPrepositionsWord() {
		return getAttributes().get(ATTRIBUTE_PREPOSITIONS).getName();
	}

	public void setPrepositions(Word prepositions) {
		getAttributes().save(ATTRIBUTE_PREPOSITIONS, prepositions);
	}

	public Word getRegularity() {
		return (Word) getAttributes().get(ATTRIBUTE_REGULARITY);
	}

	public String getRegularityWord() {
		return getRegularity().getName();
	}

	public void setRegularity(Word Transitivity) {
		getAttributes().save(ATTRIBUTE_REGULARITY, Transitivity);
	}

	public Word getTransitivity() {
		return (Word) getAttributes().get(ATTRIBUTE_TRANSITIVITY);
	}

	public String getTransitivityWord() {
		return getTransitivity().getName();
	}

	public void setTransitivity(Word transitivity) {
		getAttributes().save(ATTRIBUTE_TRANSITIVITY, transitivity);
	}

	@Override
	public WordVerb wrap(Concept concept) {
		super.wrap(concept);
		return this;
	}

}
