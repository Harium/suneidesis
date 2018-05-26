package com.harium.suneidesis.knowledge.context;

import com.harium.suneidesis.knowledge.space.SpaceConcept;
import com.harium.suneidesis.knowledge.time.TemporalConcept;

public class Context {

    // When?
    TemporalConcept time = TemporalConcept.NOW;
    // Where?
    SpaceConcept space;

    public Context() {
        space = new SpaceConcept();
    }

    public Context(TemporalConcept time) {
        this.time = time;
        space = new SpaceConcept();
    }

    public Context(TemporalConcept time, SpaceConcept space) {
        this.time = time;
        this.space = space;
    }

}
