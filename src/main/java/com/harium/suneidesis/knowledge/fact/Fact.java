package com.harium.suneidesis.knowledge.fact;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.ConceptType;
import com.harium.suneidesis.knowledge.fact.frame.FrameType;

/**
 * Fact is a model to represent actions from being's perspective
 * The same fact(action) can be perceived differently by observers and/or actors
 */

public class Fact extends Concept {

    private static final FactSource UNKNOWN_SOURCE = new FactSource("?");

    // Provenance
    protected FactSource source = UNKNOWN_SOURCE;

    protected FrameType frameType = FrameType.NONE;

    public Fact(String name) {
        super(name, ConceptType.THEORY);
    }

    public Fact(String name, FactSource source) {
        super(name, ConceptType.THEORY);
        this.source = source;
    }

    public FactSource getSource() {
        return source;
    }

    public void setSource(FactSource source) {
        this.source = source;
    }

    public FrameType getFrameType() {
        return frameType;
    }
}
