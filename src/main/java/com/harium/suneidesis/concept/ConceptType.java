package com.harium.suneidesis.concept;

public class ConceptType extends Concept {

    public static final ConceptType UNKNOWN_TYPE = new ConceptType("UNKNOWN");
    public static final ConceptType SECRET_TYPE = new ConceptType("SECRET");
    public static final ConceptType ACTION = new ConceptType("ACTION");
    public static final ConceptType ARTIFACT = new ConceptType("ARTIFACT");
    public static final ConceptType BEING = new ConceptType("BEING");
    public static final ConceptType CHARACTERISTIC = new ConceptType("CHARACTERISTIC");
    public static final ConceptType DATA = new ConceptType("DATA");
    public static final ConceptType EVENT = new ConceptType("EVENT");
    public static final ConceptType FEELING = new ConceptType("FEELING");
    public static final ConceptType MEANING = new ConceptType("MEANING");
    public static final ConceptType PART = new ConceptType("PART");
    public static final ConceptType PHENOMENON = new ConceptType("PHENOMENA");
    public static final ConceptType PLACE = new ConceptType("PLACE");
    public static final ConceptType MEASUREMENT = new ConceptType("MEASURE");
    public static final ConceptType SIMULATION = new ConceptType("SIMULATION");
    public static final ConceptType SOUND = new ConceptType("SOUND");
    public static final ConceptType SUBSTANCE = new ConceptType("SUBSTANCE");
    public static final ConceptType STORY = new ConceptType("STORY");
    public static final ConceptType UNIT = new ConceptType("UNIT");
    public static final ConceptType THEORY = new ConceptType("THEORY");
    public static final ConceptType WORD = new ConceptType("WORD");

    public static final Concept UNKNOWN = new Concept(ConceptType.UNKNOWN_TYPE);
    public static final Concept SECRET = new Concept(ConceptType.SECRET_TYPE);

    public ConceptType(String name) {
        super(name);
    }

    public static ConceptType getFromName(String name) {
        if (SECRET_TYPE.getName().equals(name)) {
            return SECRET_TYPE;
        } else if (CHARACTERISTIC.getName().equals(name)) {
            return CHARACTERISTIC;
        } else if (ACTION.getName().equals(name)) {
            return ACTION;
        } else if (ARTIFACT.getName().equals(name)) {
            return ARTIFACT;
        } else if (BEING.getName().equals(name)) {
            return BEING;
        } else if (EVENT.getName().equals(name)) {
            return EVENT;
        } else if (FEELING.getName().equals(name)) {
            return FEELING;
        } else if (MEANING.getName().equals(name)) {
            return MEANING;
        } else if (PART.getName().equals(name)) {
            return PART;
        } else if (PHENOMENON.getName().equals(name)) {
            return PHENOMENON;
        } else if (PLACE.getName().equals(name)) {
            return PLACE;
        } else if (MEASUREMENT.getName().equals(name)) {
            return MEASUREMENT;
        } else if (UNIT.getName().equals(name)) {
            return UNIT;
        } else if (SIMULATION.getName().equals(name)) {
            return SIMULATION;
        } else if (SOUND.getName().equals(name)) {
            return SOUND;
        } else if (SUBSTANCE.getName().equals(name)) {
            return SUBSTANCE;
        } else if (STORY.getName().equals(name)) {
            return STORY;
        } else if (THEORY.getName().equals(name)) {
            return THEORY;
        } else if (WORD.getName().equals(name)) {
            return WORD;
        }

        return UNKNOWN_TYPE;
    }
    
}
