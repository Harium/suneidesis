package com.harium.suneidesis.concept.inspector;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.numeral.Amount;

public class Inspector {

    private Concept concept;

    public Inspector(Concept concept) {
        this.concept = concept;
    }

    public static Inspector does(Concept concept) {
        return new Inspector(concept);
    }

    public boolean can(Action action) {
        return concept.getAttributes().getAbilities().query(action);
    }

    public boolean can(String action) {
        return concept.getAttributes().getAbilities().query(action);
    }

    public boolean has(String key, Matcher matcher) {
        Concept toEval = this.concept.getAttributes().getPart(key);
        if (!ConceptType.NUMERAL.equals(toEval.getType())) {
            return false;
        }
        Amount numeral = (Amount) toEval;
        return matcher.evaluate(numeral.getExpression());
    }

    public boolean isAt(String name) {
        Concept location = concept.getAttributes().get(Attributes.ATTRIBUTE_LOCATION);
        return name.equalsIgnoreCase(location.getName());
    }
}
