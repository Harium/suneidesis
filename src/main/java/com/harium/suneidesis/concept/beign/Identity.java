package com.harium.suneidesis.concept.beign;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Primitive;

public class Identity extends Concept {

    // Also called given name
    private static final String ATTRIBUTE_FIRST_NAME = "first_name";
    // Also called family name
    private static final String ATTRIBUTE_LAST_NAME = "last_name";

    public Identity() {
        super(ConceptType.DATA);
    }

    public Identity(String name) {
        super(name, ConceptType.DATA);
    }

    public String getFirstName() {
        return getAttributes().get(ATTRIBUTE_FIRST_NAME).getName();
    }

    public Concept getFirstNameConcept() {
        return getAttributes().get(ATTRIBUTE_FIRST_NAME);
    }

    public void setFirstName(String firstName) {
        this.getAttributes().save(ATTRIBUTE_FIRST_NAME, new Primitive(firstName));
    }

    public String getLastName() {
        return getAttributes().get(ATTRIBUTE_LAST_NAME).getName();
    }

    public Concept getLastNameConcept() {
        return getAttributes().get(ATTRIBUTE_LAST_NAME);
    }

    public void setLastName(String firstName) {
        this.getAttributes().save(ATTRIBUTE_LAST_NAME, new Primitive(firstName));
    }

}
