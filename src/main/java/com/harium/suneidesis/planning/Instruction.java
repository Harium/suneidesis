package com.harium.suneidesis.planning;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Provenance;

public class Instruction extends Concept {

    public Instruction() {
        super();
    }

    public Instruction(Concept subject, Concept predicate, Concept object) {
        super();
        set(Provenance.ATTRIBUTE_SUBJECT, subject);
        set(Provenance.ATTRIBUTE_PREDICATE, predicate);
        set(Provenance.ATTRIBUTE_OBJECT, object);
    }

}
