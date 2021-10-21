package com.harium.suneidesis.concept.time;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;

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
        value(toISO());
    }

    public String toISO() {
        StringBuilder builder = new StringBuilder();
        builder.append(getYear());
        builder.append("-");
        builder.append(getMonth());
        builder.append("-");
        builder.append(getDay());
        builder.append("T");
        builder.append(getHours());
        builder.append(":");
        builder.append(getMinutes());
        builder.append(":");
        builder.append(getSeconds());
        builder.append(".000Z");

        return builder.toString();
    }

    public String getDay() {
        return getAttributes().get(ATTRIBUTE_DAY).getValue();
    }

    public Date day(String day) {
        String value = round(day);
        has(ATTRIBUTE_DAY, new Word(value));
        return this;
    }

    public String getMonth() {
        return getAttributes().get(ATTRIBUTE_MONTH).getValue();
    }

    public Date month(String month) {
        String value = round(month);
        has(ATTRIBUTE_MONTH, new Word(value));
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
        String value = round(hour);
        has(ATTRIBUTE_HOUR, new Word(value));
        return this;
    }

    public String getMinutes() {
        return getAttributes().get(ATTRIBUTE_MINUTE).getValue();
    }

    public Date minutes(String minute) {
        String value = round(minute);
        has(ATTRIBUTE_MINUTE, new Word(value));
        return this;
    }

    public String getSeconds() {
        return getAttributes().get(ATTRIBUTE_SECOND).getValue();
    }

    public Date seconds(String second) {
        String value = round(second);
        has(ATTRIBUTE_SECOND, new Word(value));
        return this;
    }

    private String round(String value) {
        if (value.length() == 1) {
            return "0" + value;
        }
        return value;
    }

    @Override
    public Date wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
