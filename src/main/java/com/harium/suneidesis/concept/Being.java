package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.beign.Creature;
import com.harium.suneidesis.concept.beign.ancestry.Ancestry;

/**
 * Being here should be stateless
 */
public class Being extends Creature {

    public static final String ATTRIBUTE_ANCESTRY = "ancestry";
    public static final String ATTRIBUTE_GENDER = "gender";

    public Being(String name) {
        super(name);
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
        this.attributes.set(ATTRIBUTE_ANCESTRY, ancestry);
    }

    public void setGender(Concept gender) {
        this.attributes.set(ATTRIBUTE_GENDER, gender);
    }

}
