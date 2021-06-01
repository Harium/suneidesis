package com.harium.suneidesis.concept;

public class Event extends Action {

    public static final String ATTRIBUTE_ACTION = "action";
    public static final String ATTRIBUTE_THEN = "then";

    public Event(String name) {
        super(name);
        type(ConceptType.EVENT);
    }

    public Event(String name, Concept subject, Concept predicate, Concept object) {
        this(name);
        subject(subject);
        set(Action.ATTRIBUTE_PREDICATE, predicate);
        set(Action.ATTRIBUTE_OBJECT, object);
    }

    public Event action(Action action) {
        set(ATTRIBUTE_ACTION, action);
        return this;
    }

    public Event subject(Concept concept) {
        super.subject(concept);
        return this;
    }

    public Event predicate(Concept predicate) {
        super.predicate(predicate);
        return this;
    }

    public Event object(Concept predicate) {
        super.object(predicate);
        return this;
    }

    public Event then(Event event) {
        set(ATTRIBUTE_THEN, event);
        return this;
    }

    public Concept getNext() {
        return get(ATTRIBUTE_THEN);
    }

    public Event getNextEvent() {
        Concept concept = getNext();
        return new Event(concept.getName()).wrap(concept);
    }

    @Override
    public Event wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
