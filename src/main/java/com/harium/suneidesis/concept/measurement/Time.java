package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Measurement;
import com.harium.suneidesis.concept.word.Word;

public class Time extends Measurement {

    public static final String ATTRIBUTE_START = "time_start";
    public static final String ATTRIBUTE_END = "time_end";

    public static final Time NOW = new Time("time_now");
    public static final Time YESTERDAY = new Time("time_yesterday");

    public Time(String time) {
        this(time, time, time);
    }

    public Time(String name, String time) {
        this(name, time, time);
    }

    public Time(String name, String start, String end) {
        super(name, TimeUnit.DATE);
        start(start);
        end(end);
    }

    public Concept getStart() {
        return getAttributes().get(ATTRIBUTE_START);
    }

    public Time start(String start) {
        has(ATTRIBUTE_START, new Word(start));
        return this;
    }

    public Concept getEnd() {
        return getAttributes().get(ATTRIBUTE_END);
    }

    public Time end(String end) {
        has(ATTRIBUTE_END, new Word(end));
        return this;
    }

    @Override
    public Time wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
