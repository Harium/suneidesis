package com.harium.suneidesis.knowledge.time;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.ConceptType;

public class TemporalConcept extends Concept {

    public static final TemporalConcept NOW = new TemporalConcept("now", Time.PRESENT);

    private Time start;
    private Time end;

    public TemporalConcept(Time when) {
        super(ConceptType.TIME_UNIT);
        this.start = when;
        this.end = when;
    }

    public TemporalConcept(String name, Time when) {
        super(name, ConceptType.TIME_UNIT);
        this.start = when;
        this.end = when;
    }

    public TemporalConcept(String name, Time start, Time end) {
        super(name, ConceptType.TIME_UNIT);
        this.start = start;
        this.end = end;
    }

    public Time getWhen() {
        return end;
    }

    public void setWhen(Time when) {
        this.start = when;
        this.end = when;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public TemporalConcept set(Time start, Time end) {
        this.start = start;
        this.end = end;
        return this;
    }

}
