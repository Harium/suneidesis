package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.measurement.Time;

public class Action extends Concept {

    public static final String ATTRIBUTE_SUBJECT = "subject";
    public static final String ATTRIBUTE_PREDICATE = "predicate";
    public static final String ATTRIBUTE_OBJECT = "object";
    public static final String ATTRIBUTE_OBJECT_PART = "object_part";
    public static final String ATTRIBUTE_PLACE = "place";
    public static final String ATTRIBUTE_TIME = "time";
    public static final String ATTRIBUTE_PHENOMENON = "phenomenon";

    public Action(String name) {
        super(name, ConceptType.ACTION);
    }

    public Concept getSubject() {
        return getAttributes().get(ATTRIBUTE_SUBJECT);
    }

    public Action subject(Concept subject) {
        getAttributes().add(ATTRIBUTE_SUBJECT, subject);
        return this;
    }

    public Concept getPredicate() {
        return getAttributes().get(ATTRIBUTE_PREDICATE);
    }

    public Action predicate(Concept predicate) {
        getAttributes().add(ATTRIBUTE_PREDICATE, predicate);
        return this;
    }

    public Concept getObject() {
        return getAttributes().get(ATTRIBUTE_OBJECT);
    }

    public Action object(Concept object) {
        getAttributes().add(ATTRIBUTE_OBJECT, object);
        return this;
    }

    public Concept getObjectPart() {
        return getAttributes().get(ATTRIBUTE_OBJECT_PART);
    }

    public Action objectPart(Concept objectPart) {
        getAttributes().add(ATTRIBUTE_OBJECT_PART, objectPart);
        return this;
    }

    public Concept getPlace() {
        return getAttributes().get(ATTRIBUTE_PLACE);
    }

    public Action place(Place place) {
        getAttributes().add(ATTRIBUTE_PLACE, place);
        return this;
    }

    public Concept getTime() {
        return getAttributes().get(ATTRIBUTE_TIME);
    }

    public Action time(Time time) {
        getAttributes().add(ATTRIBUTE_TIME, time);
        return this;
    }

    public Concept getWeather() {
        return getAttributes().get(ATTRIBUTE_PHENOMENON);
    }

    public Action weather(Phenomenon phenomenon) {
        return phenomenon(phenomenon);
    }

    public Action phenomenon(Phenomenon phenomenon) {
        getAttributes().add(ATTRIBUTE_PHENOMENON, phenomenon);
        return this;
    }

    @Override
    public Action wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
