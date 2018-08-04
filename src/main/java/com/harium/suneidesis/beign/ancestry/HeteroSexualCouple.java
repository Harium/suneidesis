package com.harium.suneidesis.beign.ancestry;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;

/**
 * Class to represent hetero sexual couples
 * Man + Woman as Father + Mother
 */
public class HeteroSexualCouple extends Ancestry {

    private static final String NAME = "couple";

    private Being father;
    private Being mother;

    public HeteroSexualCouple(String fathersName, String mothersName) {
        super(NAME);
        this.father = new Being(fathersName);
        this.father.setGender(Gender.MALE);

        this.mother = new Being(mothersName);
        this.mother.setGender(Gender.FEMALE);
    }

    public HeteroSexualCouple(Being father, Being mother) {
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