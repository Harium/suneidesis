package com.harium.suneidesis.concept.substance;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;

public class Substance extends Concept {

    public static final String ATTRIBUTE_FORMULA = "material formula";

    public Substance(String name){
        super(name, ConceptType.SUBSTANCE);
    }

    public Concept getFormula() {
        return get(ATTRIBUTE_FORMULA);
    }

    public void setFormula(String formula) {
        has(ATTRIBUTE_FORMULA, new Concept(formula));
    }

    public void setFormula(Concept formula) {
        has(ATTRIBUTE_FORMULA, formula);
    }

}
