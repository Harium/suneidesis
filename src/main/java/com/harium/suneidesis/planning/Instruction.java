package com.harium.suneidesis.planning;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Fact;

public class Instruction extends Fact {

    public Instruction() {
        super();
    }

    public Instruction(Concept subject, Concept predicate, Concept object) {
        super();
        this.subject(subject);
        this.predicate(predicate);
        this.object(object);
    }

}
