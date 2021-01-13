package com.harium.suneidesis.concept;

/**
 * Fact is a model to represent actions from being's perspective
 * The same fact(action) can be perceived differently by observers and/or actors
 */

public class Fact extends Concept {

    // Provenance
    public static final String ATTRIBUTE_SOURCE = "source";
    public static final String ATTRIBUTE_SOURCE_ID = "source_id";
    public static final String ATTRIBUTE_ACQUISITION_METHOD = "acquisition_method";
    public static final String ATTRIBUTE_ACQUISITION_MEDIUM = "acquisition_medium";

    public static final String ATTRIBUTE_SUBJECT = "subject";
    public static final String ATTRIBUTE_PREDICATE = "predicate";
    public static final String ATTRIBUTE_OBJECT = "object";
    public static final String ATTRIBUTE_OBJECT_PART = "object_part";
    public static final String ATTRIBUTE_PLACE = "place";
    public static final String ATTRIBUTE_TIME = "time";
    public static final String ATTRIBUTE_WEATHER = "weather";
    public static final String ATTRIBUTE_THEN = "then";

    public Fact() {
        super(ConceptType.THEORY);
    }

    public Fact(String name) {
        super(name, ConceptType.THEORY);
    }

    public Fact(String name, Concept source) {
        super(name, ConceptType.THEORY);
        source(source);
    }

    public Concept getSource() {
        return attributes.get(ATTRIBUTE_SOURCE);
    }

    public Fact source(Concept source) {
        this.attributes.set(ATTRIBUTE_SOURCE, source);
        return this;
    }

    public Concept getSourceId() {
        return attributes.get(ATTRIBUTE_SOURCE_ID);
    }

    public Fact sourceId(Concept source) {
        this.attributes.set(ATTRIBUTE_SOURCE_ID, source);
        return this;
    }

    public Concept getSubject() {
        return attributes.get(ATTRIBUTE_SUBJECT);
    }

    public Fact subject(Concept subject) {
        this.attributes.set(ATTRIBUTE_SUBJECT, subject);
        return this;
    }

    public Concept getPredicate() {
        return attributes.get(ATTRIBUTE_PREDICATE);
    }

    public Fact predicate(Concept predicate) {
        this.attributes.set(ATTRIBUTE_PREDICATE, predicate);
        return this;
    }

    public Concept getObject() {
        return attributes.get(ATTRIBUTE_OBJECT);
    }

    public Fact object(Concept object) {
        this.attributes.set(ATTRIBUTE_OBJECT, object);
        return this;
    }

    public Concept getObjectPart() {
        return attributes.get(ATTRIBUTE_OBJECT_PART);
    }

    public Fact objectPart(Concept object) {
        this.attributes.set(ATTRIBUTE_OBJECT_PART, object);
        return this;
    }

    public Concept getPlace() {
        return attributes.get(ATTRIBUTE_PLACE);
    }

    public Fact place(Place place) {
        this.attributes.set(ATTRIBUTE_PLACE, place);
        return this;
    }

    public Concept getTime() {
        return attributes.get(ATTRIBUTE_TIME);
    }

    public Fact time(Time time) {
        this.attributes.set(ATTRIBUTE_TIME, time);
        return this;
    }

    public Concept getWeather() {
        return attributes.get(ATTRIBUTE_WEATHER);
    }

    public Fact weather(Phenomenon phenomenon) {
        this.attributes.set(ATTRIBUTE_WEATHER, phenomenon);
        return this;
    }

    public Fact then(Fact fact) {
        this.attributes.set(ATTRIBUTE_THEN, fact);
        return this;
    }

    public Concept getNext() {
        return attributes.get(ATTRIBUTE_THEN);
    }

    public Concept getAcquisitionMethod() {
        return attributes.get(ATTRIBUTE_ACQUISITION_METHOD);
    }

    public Fact acquisitionMethod(Action action) {
        this.attributes.set(ATTRIBUTE_ACQUISITION_METHOD, action);
        return this;
    }

    public Concept getAcquisitionMedium() {
        return attributes.get(ATTRIBUTE_ACQUISITION_MEDIUM);
    }

    public Fact acquisitionMedium(Concept medium) {
        this.attributes.set(ATTRIBUTE_ACQUISITION_MEDIUM, medium);
        return this;
    }

}
