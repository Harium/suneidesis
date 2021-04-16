package com.harium.suneidesis.concept.substance;

import com.harium.suneidesis.concept.Concept;

public class Molecule extends Substance {

    public Molecule() {
        super();
    }

    public Molecule(String name) {
        super(name);
    }

    public void add(Concept substance) {
        Concept substanceFormula = substance.get(Substance.ATTRIBUTE_FORMULA);
        if (substanceFormula.isUnknown()) {
           return;
        }

        // Improve it
        Concept formula = get(Substance.ATTRIBUTE_FORMULA);
        String current;
        if (formula.isUnknown()) {
            current = "";
        } else {
            current = formula.getName();
        }
        current += substanceFormula.getName();
        setFormula(current);
    }
}
