package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

/**
 * Class that represents bidirectional relationship between two words (synonym, antonym, collective, plural, singlular)
 * Ideally wordId should be find before the target on a database
 */
public class WordRelationship extends WordModel {

    private String targetWordId;

    private String relationship;

    public WordRelationship() {
    }

    public WordRelationship(String wordId, String targetWordId, String relationship) {
        super(wordId);
        this.targetWordId = targetWordId;
        this.relationship = relationship;
    }

    public String getTargetWordId() {
        return targetWordId;
    }

    public void setTargetWordId(String targetWordId) {
        this.targetWordId = targetWordId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
