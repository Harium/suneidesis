package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Adjective extends WordModel {

	private String gender;

	private String type;

	public Adjective() {
	}

	public Adjective(String wordId) {
		this.wordId = wordId;
	}

	public String getWordId() {
		return wordId;
	}

	public void setWordId(String wordId) {
		this.wordId = wordId;
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
