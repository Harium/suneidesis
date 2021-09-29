package com.harium.suneidesis.concept.helper;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.Measurement;
import com.harium.suneidesis.concept.word.Word;

public class Inspector {

    private Concept concept;

    public Inspector(Concept concept) {
        this.concept = concept;
    }

    public static Inspector does(Concept concept) {
        return new Inspector(concept);
    }

    public boolean is(Concept concept) {
        // Contains the concept as a superclass
        String conceptName = concept.getName();
        if (this.concept.getAttributes().queryIs(conceptName)) {
            return true;
        }

        if (this.concept.isPrimitive()) {
           return this.concept.getValue().equals(concept.getValue());
        }

        // Compare attributes
        Attributes from = this.concept.getAttributes();
        if (ConceptType.isWord(this.concept)) {
            from = this.concept.get(Word.ATTRIBUTE_MEANING).getAttributes();
        }

        Attributes target = concept.getAttributes();
        if (ConceptType.isWord(concept)) {
            target = concept.get(Word.ATTRIBUTE_MEANING).getAttributes();
        }

        // Else, compare attributes
        return target.equals(from);
    }

    public boolean can(Action action) {
        return concept.getAttributes().getAbilities().contains(action.getName());
    }

    public boolean can(String actionKey) {
        return concept.getAttributes().can(actionKey);
    }

    public boolean has(String key, Concept concept) {
        Concept toCompare = this.concept.get(key);
        return toCompare.getAttributes().equals(concept.getAttributes());
    }

    public boolean has(String key) {
        return this.concept.hasKey(key);
    }

    public boolean hasPart(String key, MeasureMatcher matcher) {
        Concept toEval = this.concept.getAttributes().getProperty(key);
        if (!ConceptType.MEASUREMENT.equals(toEval.getType())) {
            return false;
        }
        Measurement measurement = (Measurement) toEval;
        return matcher.evaluate(measurement.getValue());
    }

    public boolean isAt(String name) {
        Concept location = concept.getAttributes().get(Attributes.ATTRIBUTE_LOCATION);
        return name.equalsIgnoreCase(location.getName());
    }
}
