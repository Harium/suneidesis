package com.harium.suneidesis.concept.time;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.utils.DateUtils;

public class Date extends Time {

    private static final String ATTRIBUTE_YEAR = "year";
    private static final String ATTRIBUTE_MONTH = "month";
    private static final String ATTRIBUTE_DAY = "day";

    private static final String ATTRIBUTE_HOUR = "hour";
    private static final String ATTRIBUTE_MINUTE = "minute";
    private static final String ATTRIBUTE_SECOND = "second";

    public Date() {
        super();
    }

    public Date(int year, int month, int day, int hours, int minutes, int seconds) {
        super(TimeUnit.DATE);
        year(Integer.toString(year));
        month(Integer.toString(month));
        day(Integer.toString(day));
        hours(Integer.toString(hours));
        minutes(Integer.toString(minutes));
        seconds(Integer.toString(seconds));

        value(DateUtils.toISO(this));
    }

    public String getDay() {
        return getAttributes().get(ATTRIBUTE_DAY).getValue();
    }

    public Date day(String day) {
        has(ATTRIBUTE_DAY, new Word(day));
        return this;
    }

    public String getMonth() {
        return getAttributes().get(ATTRIBUTE_MONTH).getValue();
    }

    public Date month(String month) {
        has(ATTRIBUTE_MONTH, new Word(month));
        return this;
    }

    public String getYear() {
        return getAttributes().get(ATTRIBUTE_YEAR).getValue();
    }

    public Date year(String year) {
        has(ATTRIBUTE_YEAR, new Word(year));
        return this;
    }

    public String getHours() {
        return getAttributes().get(ATTRIBUTE_HOUR).getValue();
    }

    public Date hours(String hour) {
        has(ATTRIBUTE_HOUR, new Word(hour));
        return this;
    }

    public String getMinutes() {
        return getAttributes().get(ATTRIBUTE_MINUTE).getValue();
    }

    public Date minutes(String minute) {
        has(ATTRIBUTE_MINUTE, new Word(minute));
        return this;
    }

    public String getSeconds() {
        return getAttributes().get(ATTRIBUTE_SECOND).getValue();
    }

    public Date seconds(String second) {
        has(ATTRIBUTE_SECOND, new Word(second));
        return this;
    }

    @Override
    public Date wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
