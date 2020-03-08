package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

/**
 * Class that represents relationship between two words (synonym, antonym, collective, plural, singlular)
 */
public class WordRelationship {

    private String word;

    private String target;

    private String relationship;

    public WordRelationship() {
    }

    public WordRelationship(String word, String target, String relationship) {
        this.word = word;
        this.target = target;
        this.relationship = relationship;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
