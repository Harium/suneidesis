package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Adjective {

	private String word;

	private String gender;

	private String type;

	public Adjective() {
	}

	public Adjective(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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
