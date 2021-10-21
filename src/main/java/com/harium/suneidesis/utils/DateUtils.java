package com.harium.suneidesis.utils;

import com.harium.suneidesis.concept.time.Date;

public class DateUtils {

    public static String toISO(Date date) {
        StringBuilder builder = new StringBuilder();
        builder.append(date.getYear());
        builder.append("-");
        builder.append(date.getMonth());
        builder.append("-");
        builder.append(date.getDay());
        builder.append("T");
        builder.append(date.getHours());
        builder.append(":");
        builder.append(date.getMinutes());
        builder.append(":");
        builder.append(date.getSeconds());
        builder.append(".000Z");

        return builder.toString();
    }

    public static String toCronExpression(Date date) {
        StringBuilder builder = new StringBuilder();
        builder.append(date.getSeconds());
        builder.append(" ");
        builder.append(date.getMinutes());
        builder.append(" ");
        builder.append(date.getHours());
        builder.append(" ");
        builder.append(date.getDay());
        builder.append(" ");
        builder.append(date.getMonth());
        builder.append(" ");
        builder.append(date.getYear());
        return builder.toString();
    }

    public static boolean checkCronExpression(String expression, Date date) {
        String wildcard = "*";
        String[] parts = expression.split(" ");

        if (!parts[0].equals(wildcard) && !parts[0].equals(date.getSeconds())) {
            return false;
        } else if (!parts[1].equals(wildcard) && !parts[1].equals(date.getMinutes())) {
            return false;
        } else if (!parts[2].equals(wildcard) && !parts[2].equals(date.getHours())) {
            return false;
        } else if (!parts[3].equals(wildcard) && !parts[3].equals(date.getDay())) {
            return false;
        } else if (!parts[4].equals(wildcard) && !parts[4].equals(date.getMonth())) {
            return false;
        } else if (!parts[5].equals(wildcard) && !parts[5].equals(date.getYear())) {
            return false;
        }

        return true;
    }
}
