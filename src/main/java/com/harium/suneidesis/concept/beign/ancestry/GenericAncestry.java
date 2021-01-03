package com.harium.suneidesis.concept.beign.ancestry;

import com.harium.suneidesis.concept.Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to represent individuals created from one or more genetic sources
 */
public class GenericAncestry extends Ancestry {

    private static final String NAME = "progenitors";

    private List<Concept> progenitors = new ArrayList<>();

    public GenericAncestry() {
        super(NAME);
    }

    public GenericAncestry(String name) {
        super(name);
    }

    public GenericAncestry(Concept... progenitors) {
        super(NAME);
        this.progenitors.addAll(Arrays.asList(progenitors));
    }

    public GenericAncestry(String name, Concept... progenitors) {
        super(name);
        this.progenitors.addAll(Arrays.asList(progenitors));
    }

    public List<Concept> getProgenitors() {
        return progenitors;
    }

    public void setProgenitors(List<Concept> progenitors) {
        this.progenitors = progenitors;
    }
}