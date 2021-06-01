package com.harium.suneidesis.repository.word;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.helper.Provenance;
import com.harium.suneidesis.repository.decorator.EntryDecorator;

public class ProvenanceDictionaryDecorator implements EntryDecorator {

    public static final Concept MEDIUM_TEXT = new Concept("dictionary");
    public static final Action METHOD_INPUT = new Action("input");

    @Override
    public void decorate(Concept concept) {
        concept.set(Provenance.ATTRIBUTE_ACQUISITION_MEDIUM, MEDIUM_TEXT);
        concept.set(Provenance.ATTRIBUTE_ACQUISITION_METHOD, METHOD_INPUT);
    }

}
