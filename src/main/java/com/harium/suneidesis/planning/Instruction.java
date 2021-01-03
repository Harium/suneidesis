package com.harium.suneidesis.planning;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.knowledge.fact.frame.Triple;
import com.harium.suneidesis.knowledge.time.TemporalConcept;

public class Instruction extends Triple {

    protected Concept whereInObject;
    protected TemporalConcept when;

    public Instruction() {
        super();
    }

    public Instruction(Concept subject, Concept predicate, Concept object) {
        super(subject, predicate, object);
    }

    public Concept getWhereInObject() {
        return whereInObject;
    }

    public void setWhereInObject(Concept whereInObject) {
        this.whereInObject = whereInObject;
    }

    public TemporalConcept getWhen() {
        return when;
    }

    public void setWhen(TemporalConcept when) {
        this.when = when;
    }

}
