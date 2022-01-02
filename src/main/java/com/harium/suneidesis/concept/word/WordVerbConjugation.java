package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordVerbConjugation extends Word {

	public static final String ATTRIBUTE_MOOD = "mood";
	public static final String ATTRIBUTE_PERSON = "person";
	public static final String ATTRIBUTE_TENSE = "tense";

	public WordVerbConjugation(String name) {
		super(name, Tag.VERB_CONJUGATION);
	}

	public Word getMood() {
		return (Word) getAttributes().get(ATTRIBUTE_MOOD);
	}

	public String getMoodWord() {
		return getMood().getName();
	}

	public void setMood(Word mood) {
		getAttributes().save(ATTRIBUTE_MOOD, mood);
	}

	public Word getPerson() {
		return (Word) getAttributes().get(ATTRIBUTE_PERSON);
	}

	public String getPersonWord() {
		return getPerson().getName();
	}

	public void setPerson(Word person) {
		getAttributes().save(ATTRIBUTE_PERSON, person);
	}

	public Word getTense() {
		return (Word) getAttributes().get(ATTRIBUTE_TENSE);
	}

	public String getTenseWord() {
		return getTense().getName();
	}

	public void setTense(Word tense) {
		getAttributes().save(ATTRIBUTE_TENSE, tense);
	}

	@Override
	public WordVerbConjugation wrap(Concept concept) {
		super.wrap(concept);
		return this;
	}

}
