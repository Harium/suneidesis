package com.harium.suneidesis.concept.time;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;

public class TimeRange extends Time {

    public static final String ATTRIBUTE_START = "time_start";
    public static final String ATTRIBUTE_END = "time_end";

    public TimeRange(String time) {
        this(time, time, time);
    }

    public TimeRange(String name, String time) {
        this(name, time, time);
    }

    public TimeRange(String name, String start, String end) {
        super(name, TimeUnit.RANGE);
        start(start);
        end(end);
    }

    public Concept getStart() {
        return getAttributes().get(ATTRIBUTE_START);
    }

    public TimeRange start(String start) {
        has(ATTRIBUTE_START, new Word(start));
        return this;
    }

    public Concept getEnd() {
        return getAttributes().get(ATTRIBUTE_END);
    }

    public TimeRange end(String end) {
        has(ATTRIBUTE_END, new Word(end));
        return this;
    }

    @Override
    public TimeRange wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
