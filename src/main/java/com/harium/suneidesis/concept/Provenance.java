package com.harium.suneidesis.concept;

/**
 * Provenance is a model that wraps concepts to represent actions from being's perspective
 * The same fact(action) can be perceived differently by observers and/or actors
 */

public class Provenance {

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
    public static final String ATTRIBUTE_PHENOMENON = "phenomenon";
    public static final String ATTRIBUTE_THEN = "then";

    private final Concept concept;

    public Provenance(Concept concept) {
        this.concept = concept;
    }

    public Concept getSource() {
        return concept.attributes.get(ATTRIBUTE_SOURCE);
    }

    public Provenance source(Concept source) {
        concept.attributes.insert(ATTRIBUTE_SOURCE, source);
        return this;
    }

    public static void setSource(Concept concept, Concept source) {
        concept.attributes.insert(ATTRIBUTE_SOURCE, source);
    }

    public Concept getSourceId() {
        return concept.attributes.get(ATTRIBUTE_SOURCE_ID);
    }

    public Provenance sourceId(Concept sourceId) {
        concept.attributes.insert(ATTRIBUTE_SOURCE_ID, sourceId);
        return this;
    }

    public static void setSourceId(Concept concept, Concept sourceId) {
        concept.attributes.insert(ATTRIBUTE_SOURCE_ID, sourceId);
    }

    public Concept getSubject() {
        return concept.attributes.get(ATTRIBUTE_SUBJECT);
    }

    public Provenance subject(Concept subject) {
        concept.attributes.insert(ATTRIBUTE_SUBJECT, subject);
        return this;
    }

    public static void setSubject(Concept concept, Concept subject) {
        concept.attributes.insert(ATTRIBUTE_SUBJECT, subject);
    }

    public Concept getPredicate() {
        return concept.attributes.get(ATTRIBUTE_PREDICATE);
    }

    public Provenance predicate(Concept predicate) {
        concept.attributes.insert(ATTRIBUTE_PREDICATE, predicate);
        return this;
    }

    public static void setPredicate(Concept concept, Concept predicate) {
        concept.attributes.insert(ATTRIBUTE_PREDICATE, predicate);
    }

    public Concept getObject() {
        return concept.attributes.get(ATTRIBUTE_OBJECT);
    }

    public Provenance object(Concept object) {
        concept.attributes.insert(ATTRIBUTE_OBJECT, object);
        return this;
    }

    public static void setObject(Concept concept, Concept object) {
        concept.attributes.insert(ATTRIBUTE_OBJECT, object);
    }

    public Concept getObjectPart() {
        return concept.attributes.get(ATTRIBUTE_OBJECT_PART);
    }

    public Provenance objectPart(Concept objectPart) {
        concept.attributes.insert(ATTRIBUTE_OBJECT_PART, objectPart);
        return this;
    }

    public static void setObjectPart(Concept concept, Concept objectPart) {
        concept.attributes.insert(ATTRIBUTE_OBJECT_PART, objectPart);
    }

    public Concept getPlace() {
        return concept.attributes.get(ATTRIBUTE_PLACE);
    }

    public Provenance place(Place place) {
        concept.attributes.insert(ATTRIBUTE_PLACE, place);
        return this;
    }

    public static void setPlace(Concept concept, Concept place) {
        concept.attributes.insert(ATTRIBUTE_PLACE, place);
    }

    public Concept getTime() {
        return concept.attributes.get(ATTRIBUTE_TIME);
    }

    public Provenance time(Time time) {
        concept.attributes.insert(ATTRIBUTE_TIME, time);
        return this;
    }

    public static void setTime(Concept concept, Concept time) {
        concept.attributes.insert(ATTRIBUTE_TIME, time);
    }

    public Concept getWeather() {
        return concept.attributes.get(ATTRIBUTE_PHENOMENON);
    }

    public Provenance weather(Phenomenon phenomenon) {
        concept.attributes.insert(ATTRIBUTE_PHENOMENON, phenomenon);
        return this;
    }

    public static void setPhenomenon(Concept concept, Concept phenomenon) {
        concept.attributes.insert(ATTRIBUTE_PHENOMENON, phenomenon);
    }

    public Provenance then(Concept fact) {
        concept.attributes.insert(ATTRIBUTE_THEN, fact);
        return this;
    }

    public static void setThen(Concept concept, Concept then) {
        concept.attributes.insert(ATTRIBUTE_THEN, then);
    }

    public Concept getNext() {
        return concept.attributes.get(ATTRIBUTE_THEN);
    }

    public Concept getAcquisitionMethod() {
        return concept.attributes.get(ATTRIBUTE_ACQUISITION_METHOD);
    }

    public Provenance acquisitionMethod(Action action) {
        concept.attributes.insert(ATTRIBUTE_ACQUISITION_METHOD, action);
        return this;
    }

    public static void setAcquisitionMethod(Concept concept, Action action) {
        concept.attributes.insert(ATTRIBUTE_ACQUISITION_METHOD, action);
    }

    public Concept getAcquisitionMedium() {
        return concept.attributes.get(ATTRIBUTE_ACQUISITION_MEDIUM);
    }

    public Provenance acquisitionMedium(Concept medium) {
        concept.attributes.insert(ATTRIBUTE_ACQUISITION_MEDIUM, medium);
        return this;
    }

    public static void setAcquisitionMedium(Concept concept, Concept medium) {
        concept.attributes.insert(ATTRIBUTE_ACQUISITION_MEDIUM, medium);
    }
}
