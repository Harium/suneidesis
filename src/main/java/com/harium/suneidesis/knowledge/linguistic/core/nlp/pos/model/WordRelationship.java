package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

/**
 * Class that represents relationship between two words (synonym, antonym, collective, plural, singlular)
 */
public class WordRelationship {

    private long wordId;

    private long targetId;

    private String relationship;

    public WordRelationship() {
    }

    public WordRelationship(long wordId, long targetId, String relationship) {
        this.wordId = wordId;
        this.targetId = targetId;
        this.relationship = relationship;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
