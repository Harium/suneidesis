package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Adjective {

	private long wordId;

	private String gender;

	private String type;

	public Adjective() {
	}

	public Adjective(long wordId) {
		this.wordId = wordId;
	}

	public long getWord() {
		return wordId;
	}

	public void setWord(long word) {
		this.wordId = word;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
