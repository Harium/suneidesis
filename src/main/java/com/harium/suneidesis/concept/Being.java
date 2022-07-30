package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.beign.ancestry.Ancestry;
import com.harium.suneidesis.concept.measurement.Measurement;

/**
 * Being here should be stateless
 */
public class Being extends Concept {

    public static final String ATTRIBUTE_ANCESTRY = "ancestry";
    public static final String ATTRIBUTE_GENDER = "gender";

    public Being(String name) {
        super(name, ConceptType.BEING);
        hasQuantity(new Concept("life"), new Measurement("one", "1"));
    }

    public Being(String name, Concept gender) {
        this(name);
        setGender(gender);
    }

    public Concept getGender() {
        return getAttributes().get(ATTRIBUTE_GENDER);
    }

    public Ancestry getAncestry() {
        return (Ancestry) getAttributes().get(ATTRIBUTE_ANCESTRY);
    }

    public void setAncestry(Ancestry ancestry) {
        this.getAttributes().save(ATTRIBUTE_ANCESTRY, ancestry);
    }

    public void setGender(Concept gender) {
        this.getAttributes().save(ATTRIBUTE_GENDER, gender);
    }

    @Override
    public Being wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
