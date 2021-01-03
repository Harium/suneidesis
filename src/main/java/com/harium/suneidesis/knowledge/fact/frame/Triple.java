package com.harium.suneidesis.knowledge.fact.frame;

import com.harium.suneidesis.concept.Concept;

public class Triple {

    protected Concept subject;
    protected Concept predicate;
    protected Concept object;

    public Triple() {
        super();
    }

    public Triple(Concept subject, Concept predicate, Concept object) {
        super();
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    public Concept getSubject() {
        return subject;
    }

    public void setSubject(Concept subject) {
        this.subject = subject;
    }

    public Concept getPredicate() {
        return predicate;
    }

    public void setPredicate(Concept predicate) {
        this.predicate = predicate;
    }

    public Concept getObject() {
        return object;
    }

    public void setObject(Concept object) {
        this.object = object;
    }

    public String toString() {
        return "(" + subject.getName() + "->" + predicate.getName() + "->" + object.getName() + ")";
    }
}
