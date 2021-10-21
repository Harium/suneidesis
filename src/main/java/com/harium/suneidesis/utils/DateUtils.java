package com.harium.suneidesis.utils;

import com.harium.suneidesis.concept.time.Date;

public class DateUtils {

    public static String toISO(Date date) {
        StringBuilder builder = new StringBuilder();
        builder.append(round(date.getYear()));
        builder.append("-");
        builder.append(round(date.getMonth()));
        builder.append("-");
        builder.append(round(date.getDay()));
        builder.append("T");
        builder.append(round(date.getHours()));
        builder.append(":");
        builder.append(round(date.getMinutes()));
        builder.append(":");
        builder.append(round(date.getSeconds()));
        builder.append(".000Z");

        return builder.toString();
    }

    private static String round(String value) {
        if (value.length() == 1) {
            return "0" + value;
        }
        return value;
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
        String[] parts = expression.split(" ");
        if (parts.length < 6) {
            return false;
        }

        if (!isWildcard(parts[0]) && !parts[0].equals(date.getSeconds())) {
            return false;
        } else if (!isWildcard(parts[1]) && !parts[1].equals(date.getMinutes())) {
            return false;
        } else if (!isWildcard(parts[2]) && !parts[2].equals(date.getHours())) {
            return false;
        } else if (!isWildcard(parts[3]) && !parts[3].equals(date.getDay())) {
            return false;
        } else if (!isWildcard(parts[4]) && !parts[4].equals(date.getMonth())) {
            return false;
        } else if (!isWildcard(parts[5]) && !parts[5].equals(date.getYear())) {
            return false;
        }

        return true;
    }

    private static boolean isWildcard(String part) {
        String wildcard = "*";
        String questionMark = "?";
        return wildcard.equals(part) || questionMark.equals(part);
    }
}
