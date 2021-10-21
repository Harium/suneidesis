package com.harium.suneidesis.concept.time;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Measurement;

public class Time extends Measurement {

    public static final Time NOW = new Time("time_now");
    public static final Time YESTERDAY = new Time("time_yesterday");

    public Time(String name) {
        super(name, TimeUnit.DATE);
    }

    public Time(TimeUnit timeUnit) {
        super(timeUnit);
    }

    public Time(String name, TimeUnit unit) {
        super(name, unit);
    }

    @Override
    public Time wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
