package com.harium.suneidesis.beign;

import com.harium.suneidesis.beign.ancestry.Ancestry;

/**
 * Being here should be stateless
 */
public class Being extends Creature {

    private Ancestry ancestry = null;

    protected Gender gender = Gender.UNKNOWN;

    public Being(String name) {
        super(name);
    }

    public Being(String name, Gender gender) {
        this(name);
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public Ancestry getAncestry() {
        return ancestry;
    }

    public void setAncestry(Ancestry ancestry) {
        this.ancestry = ancestry;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
