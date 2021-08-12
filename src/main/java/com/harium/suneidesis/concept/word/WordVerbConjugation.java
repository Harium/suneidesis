package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordVerbConjugation extends Word {

	public static final String ATTRIBUTE_PERSON = "person";
	public static final String ATTRIBUTE_TENSE = "tense";

	public WordVerbConjugation(String name) {
		super(name, Tag.VERB_CONJUGATION);
	}
	
	public Word getPerson() {
		return (Word) getAttributes().get(ATTRIBUTE_PERSON);
	}

	public String getPersonWord() {
		return getAttributes().get(ATTRIBUTE_PERSON).getName();
	}

	public void setPerson(Word person) {
		getAttributes().add(ATTRIBUTE_PERSON, person);
	}

	public Word getTense() {
		return (Word) getAttributes().get(ATTRIBUTE_TENSE);
	}

	public String getTenseWord() {
		return getTense().getName();
	}

	public void setTense(Word tense) {
		getAttributes().add(ATTRIBUTE_TENSE, tense);
	}

	@Override
	public WordVerbConjugation wrap(Concept concept) {
		super.wrap(concept);
		return this;
	}

}
