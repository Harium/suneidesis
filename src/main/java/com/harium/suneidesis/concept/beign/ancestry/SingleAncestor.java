package com.harium.suneidesis.concept.beign.ancestry;

import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.ConceptType;

/**
 * Class to represent individuals created from a single genetic source
 * Useful to express clones
 */
public class SingleAncestor extends Ancestry {

    private static final String NAME = "source";

    private Being source;

    public SingleAncestor(String ancestorName) {
        super(NAME);
        this.source = new Being(ancestorName);
        this.source.setGender(ConceptType.UNKNOWN);
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