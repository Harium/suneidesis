package com.harium.suneidesis.inspector;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.numeral.Measure;

public class Inspector {

    private Concept concept;

    public Inspector(Concept concept) {
        this.concept = concept;
    }

    public static Inspector does(Concept concept) {
        return new Inspector(concept);
    }

    public boolean is(Concept concept) {
        return this.concept.getAttributes().equals(concept.getAttributes());
    }

    public boolean can(Action action) {
        return concept.getAttributes().getAbilities().query(action);
    }

    public boolean can(String action) {
        return concept.getAttributes().getAbilities().query(action);
    }

    public boolean has(String key, Concept concept) {
        Concept toCompare = this.concept.get(key);
        return toCompare.getAttributes().equals(concept.getAttributes());
    }

    public boolean hasPart(String key, Matcher matcher) {
        Concept toEval = this.concept.getAttributes().getProperty(key);
        if (!ConceptType.MEASURE.equals(toEval.getType())) {
            return false;
        }
        Measure measure = (Measure) toEval;
        return matcher.evaluate(measure.getValueText());
    }

    public boolean isAt(String name) {
        Concept location = concept.getAttributes().get(Attributes.ATTRIBUTE_LOCATION);
        return name.equalsIgnoreCase(location.getName());
    }
}