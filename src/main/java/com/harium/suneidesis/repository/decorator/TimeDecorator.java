package com.harium.suneidesis.repository.decorator;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Time;
import com.harium.suneidesis.repository.generator.TimeGenerator;

public class TimeDecorator implements EntryDecorator {

    public static final String ATTRIBUTE_CREATED_AT = "created_at";

    private final TimeGenerator timeGenerator;

    public TimeDecorator(TimeGenerator timeGenerator) {
        this.timeGenerator = timeGenerator;
    }

    @Override
    public void decorate(Concept concept) {
        String when = timeGenerator.generateTime();

        Time time = new Time(when);
        concept.set(ATTRIBUTE_CREATED_AT, time);
    }
}
