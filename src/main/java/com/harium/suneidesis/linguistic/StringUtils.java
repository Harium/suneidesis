package com.harium.suneidesis.linguistic;

import java.util.List;

public class StringUtils {

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String join(String delimiter, List<String> words) {
        return join(delimiter, delimiter, words);
    }

    public static String join(String delimiter, String lastDelimiter, List<String> words) {
        StringBuilder builder = new StringBuilder();

        int i = 0;

        for (String scheduleStop : words) {
            builder.append(scheduleStop);
            if (i < words.size() - 1) {
                if (i == words.size() - 2) {
                    builder.append(lastDelimiter);
                } else {
                    builder.append(delimiter);
                }
            }
            i++;
        }

        return builder.toString();
    }

}

