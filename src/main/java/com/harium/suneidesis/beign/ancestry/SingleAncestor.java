package com.harium.suneidesis.beign.ancestry;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;

/**
 * Class to represent a single ancestor
 * Useful to express clones' source
 */
public class SingleAncestor extends Ancestry {

    private static final String NAME = "source";

    private Being source;

    public SingleAncestor(String ancestorName) {
        super(NAME);
        this.source = new Being(ancestorName);
        this.source.setGender(Gender.UNKNOWN);
    }

    public SingleAncestor(Being source) {
        super(NAME);
        this.source = source;
    }

    public Being getSource() {
        return source;
    }

    public void setSource(Being source) {
        this.source = source;
    }

}