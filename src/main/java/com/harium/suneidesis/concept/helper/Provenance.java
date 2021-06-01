package com.harium.suneidesis.concept.helper;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Phenomenon;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.concept.measurement.Time;

/**
 * Provenance is a model that wraps concepts to represent actions from being's perspective
 * The same fact(action) can be perceived differently by observers and/or actors
 */

public class Provenance {

    public static final String ATTRIBUTE_SOURCE = "source";
    public static final String ATTRIBUTE_SOURCE_ID = "source_id";
    public static final String ATTRIBUTE_ACQUISITION_METHOD = "acquisition_method";
    public static final String ATTRIBUTE_ACQUISITION_MEDIUM = "acquisition_medium";

    private final Concept concept;

    public Provenance(Concept concept) {
        this.concept = concept;
    }

    public Concept getSource() {
        return concept.getAttributes().get(ATTRIBUTE_SOURCE);
    }

    public Provenance source(Concept source) {
        setSource(concept, source);
        return this;
    }

    public static void setSource(Concept concept, Concept source) {
        concept.getAttributes().insert(ATTRIBUTE_SOURCE, source);
    }

    public Concept getSourceId() {
        return concept.getAttributes().get(ATTRIBUTE_SOURCE_ID);
    }

    public Provenance sourceId(Concept sourceId) {
        setSourceId(concept, sourceId);
        return this;
    }

    public static void setSourceId(Concept concept, Concept sourceId) {
        concept.getAttributes().insert(ATTRIBUTE_SOURCE_ID, sourceId);
    }

    public Concept getAcquisitionMethod() {
        return concept.getAttributes().get(ATTRIBUTE_ACQUISITION_METHOD);
    }

    public Provenance acquisitionMethod(Action action) {
        setAcquisitionMethod(concept, action);
        return this;
    }

    public static void setAcquisitionMethod(Concept concept, Action action) {
        concept.getAttributes().insert(ATTRIBUTE_ACQUISITION_METHOD, action);
    }

    public Concept getAcquisitionMedium() {
        return concept.getAttributes().get(ATTRIBUTE_ACQUISITION_MEDIUM);
    }

    public Provenance acquisitionMedium(Concept medium) {
        setAcquisitionMedium(concept, medium);
        return this;
    }

    public static void setAcquisitionMedium(Concept concept, Concept medium) {
        concept.getAttributes().insert(ATTRIBUTE_ACQUISITION_MEDIUM, medium);
    }
}
