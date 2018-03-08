package com.harium.suneidesis.knowledge.beign.ancestry;

import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.beign.Gender;

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