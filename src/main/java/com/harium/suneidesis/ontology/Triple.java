package com.harium.suneidesis.ontology;

import com.harium.suneidesis.knowledge.concept.Concept;

public class Triple extends Concept {

    protected Concept subject;
    protected Concept predicate;
    protected Concept object;

    public Triple() {
        super("");
    }

    public Triple(String name) {
        super(name);
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
