package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Unit;

public class TimeUnit extends Unit {

    public static final TimeUnit DATE = new TimeUnit("date", "");
    public static final TimeUnit HOUR = new TimeUnit("hour", "h");
    public static final TimeUnit MINUTE = new TimeUnit("minute", "m");
    public static final TimeUnit SECOND = new TimeUnit("second", "s");

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
