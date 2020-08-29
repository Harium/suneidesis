package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

/**
 * Class that represents bidirectional relationship between two words (synonym, antonym, collective, plural, singlular)
 * Ideally wordId should be find before the target on a database
 */
public class WordRelationship extends WordModel {

    private String targetId;

    private String relationship;

    public WordRelationship() {
    }

    public WordRelationship(String wordId, String targetId, String relationship) {
        super(wordId);
        this.targetId = targetId;
        this.relationship = relationship;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
