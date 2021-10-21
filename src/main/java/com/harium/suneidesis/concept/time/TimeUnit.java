package com.harium.suneidesis.concept.time;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Unit;

public class TimeUnit extends Unit {

    public static final TimeUnit DATE = new TimeUnit("date", "");
    public static final TimeUnit RANGE = new TimeUnit("date", "~");

    public TimeUnit(String name) {
        super(name);
        unitType(Unit.UNIT_TYPE_TIME);
    }

    public TimeUnit(String name, String symbol) {
        super(name, symbol);
        unitType(Unit.UNIT_TYPE_TIME);
    }

    @Override
    public TimeUnit wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
