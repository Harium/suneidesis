package com.harium.suneidesis.concept.beign.ancestry;

import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.beign.Gender;

/**
 * Class to represent being couples (specifically constituted by a female and a male being)
 *
 * This class was created to deal with genealogical trees
 */
public class BeingCouple extends Ancestry {

    private static final String NAME = "couple";

    private Being father;
    private Being mother;

    public BeingCouple(String fathersName, String mothersName) {
        super(NAME);
        this.father = new Being(fathersName);
        this.father.setGender(Gender.MALE);

        this.mother = new Being(mothersName);
        this.mother.setGender(Gender.FEMALE);
    }

    public BeingCouple(Being father, Being mother) {
        super(NAME);
        this.father = father;
        this.mother = mother;
    }

    public Being getFather() {
        return father;
    }

    public void setFather(Being father) {
        this.father = father;
    }

    public Being getMother() {
        return mother;
    }

    public void setMother(Being mother) {
        this.mother = mother;
    }
}