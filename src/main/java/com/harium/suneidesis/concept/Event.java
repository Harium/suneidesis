package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.helper.Provenance;

public class Event extends Concept {

    public static final String ATTRIBUTE_THEN = "then";

    public Event() {
        super(ConceptType.EVENT);
    }

    public Event(String name) {
        super(name, ConceptType.EVENT);
    }

    public Event(Concept subject, Concept predicate, Concept object) {
        super(ConceptType.EVENT);
        subject(subject);
        set(Provenance.ATTRIBUTE_PREDICATE, predicate);
        set(Provenance.ATTRIBUTE_OBJECT, object);
    }

    public Event subject(Concept subject) {
        set(Provenance.ATTRIBUTE_SUBJECT, subject);
        return this;
    }

    public Event action(Concept action) {
        set(Provenance.ATTRIBUTE_PREDICATE, action);
        return this;
    }

    public Event object(Concept object) {
        set(Provenance.ATTRIBUTE_OBJECT, object);
        return this;
    }

    public Event then(Event event) {
        set(ATTRIBUTE_THEN, event);
        return this;
    }

    public Event getNext() {
        return (Event) get(ATTRIBUTE_THEN);
    }

}
