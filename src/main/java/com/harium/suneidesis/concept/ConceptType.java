package com.harium.suneidesis.concept;

public class ConceptType {

    public static final Concept UNKNOWN = new Concept("UNKNOWN");
    public static final Concept SECRET = new Concept("SECRET");
    public static final Concept ACTION = new Concept("ACTION");
    public static final Concept ARTIFACT = new Concept("ARTIFACT");
    public static final Concept BEING = new Concept("BEING");
    public static final Concept CHARACTERISTIC = new Concept("CHARACTERISTIC");
    public static final Concept DATA = new Concept("DATA");
    public static final Concept EVENT = new Concept("EVENT");
    public static final Concept FEELING = new Concept("FEELING");
    public static final Concept MEANING = new Concept("MEANING");
    public static final Concept PART = new Concept("PART");
    public static final Concept PHENOMENON = new Concept("PHENOMENA");
    public static final Concept PLACE = new Concept("PLACE");
    public static final Concept MEASUREMENT = new Concept("MEASURE");
    public static final Concept SIMULATION = new Concept("SIMULATION");
    public static final Concept SOUND = new Concept("SOUND");
    public static final Concept SUBSTANCE = new Concept("SUBSTANCE");
    public static final Concept STORY = new Concept("STORY");
    public static final Concept TIME_UNIT = new Concept("TIME UNIT");
    public static final Concept THEORY = new Concept("THEORY");
    public static final Concept WORD = new Concept("WORD");

    public static Concept getFromName(String name) {
        if (SECRET.getName().equals(name)) {
            return SECRET;
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
        } else if (TIME_UNIT.getName().equals(name)) {
            return TIME_UNIT;
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

        return UNKNOWN;
    }
    
}
