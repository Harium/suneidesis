package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.beign.ancestry.Ancestry;
import com.harium.suneidesis.concept.numeral.Measure;

/**
 * Being here should be stateless
 */
public class Being extends Concept {

    public static final String ATTRIBUTE_ANCESTRY = "ancestry";
    public static final String ATTRIBUTE_GENDER = "gender";

    public Being() {
        super(ConceptType.BEING);
        hasQuantity(new Concept("life"), new Measure("one", "1"));
    }

    public Being(String name) {
        super(name, ConceptType.BEING);
        hasQuantity(new Concept("life"), new Measure("one", "1"));
    }

    public Being(String name, Concept gender) {
        this(name);
        setGender(gender);
    }

    public Concept getGender() {
        return attributes.get(ATTRIBUTE_GENDER);
    }

    public Ancestry getAncestry() {
        return (Ancestry) attributes.get(ATTRIBUTE_ANCESTRY);
    }

    public void setAncestry(Ancestry ancestry) {
        this.attributes.insert(ATTRIBUTE_ANCESTRY, ancestry);
    }

    public void setGender(Concept gender) {
        this.attributes.insert(ATTRIBUTE_GENDER, gender);
    }

}
