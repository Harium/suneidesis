package com.harium.suneidesis.knowledge.fact.frame;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.fact.Fact;

public class TripleFact extends Fact {

    private Triple triple;

    public TripleFact() {
        super("");
        frameType = FrameType.TRIPLE;
    }

    public TripleFact(String name) {
        super(name);
        frameType = FrameType.TRIPLE;
    }

    public TripleFact(Concept subject, Concept predicate, Concept object) {
        this();
        triple = new Triple(subject, predicate, object);
    }

    @Override
    public String toString() {
        return "TripleFact{" +
                "triple=" + triple +
                '}';
    }

    public Concept getSubject() {
        return triple.getSubject();
    }

    public Concept getPredicate() {
        return triple.getPredicate();
    }

    public Concept getObject() {
        return triple.getObject();
    }

}
