package com.harium.suneidesis.knowledge.fact.frame;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.fact.Fact;

public class Triple extends Fact {

    protected Concept subject;
    protected Concept predicate;
    protected Concept object;

    public Triple() {
        super("");
        frameType = FrameType.TRIPLE;
    }

    public Triple(String name) {
        super(name);
        frameType = FrameType.TRIPLE;
    }

    public Triple(Concept subject, Concept predicate, Concept object) {
        this();
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    public String toString() {
        return "(" + subject.getName() + "->" + predicate.getName() + "->" + object.getName() + ")";
    }
}
