package com.harium.suneidesis.concept;

/**
 * Class that represents bidirectional relationship between two concepts,
 * Eg: in words (synonym, antonym, collective, plural, singular)
 */
public class Relationship extends Concept {

    private Concept conceptA;

    private Concept conceptB;

    private Concept relationship;

    public Relationship(String name, Concept conceptA, Concept conceptB, Concept relationship) {
        super(name);
        this.conceptA = conceptA;
        this.conceptB = conceptB;
        this.relationship = relationship;
    }

    public Concept getConceptA() {
        return conceptA;
    }

    public void setConceptA(Concept conceptA) {
        this.conceptA = conceptA;
    }

    public Concept getConceptB() {
        return conceptB;
    }

    public void setConceptB(Concept conceptB) {
        this.conceptB = conceptB;
    }

    public Concept getRelationship() {
        return relationship;
    }

    public void setRelationship(Concept relationship) {
        this.relationship = relationship;
    }
}
