package com.harium.suneidesis.knowledge.linguistic.english.feeling;

import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.beign.Status;
import com.harium.suneidesis.knowledge.linguistic.core.feeling.FeelingParser;

public class SimpleFeelingParser implements FeelingParser {

    private static final float interval = Status.MAX / 5;
    private static final float INTERVAL_HIGH = interval * 4; // 80%
    private static final float INTERVAL_GOOD = interval * 3; // 60%
    private static final float INTERVAL_BAD = Status.NEUTRAL; // 50%

    private static final String LABEL_FINE = "fine";
    private static final String LABEL_GOOD = "good";
    private static final String LABEL_BAD = "bad";

    @Override
    public String parse(String query, Being beign) {
        if (query.contains("You")) {
            return "I am " + translateFeelingToString(beign.getStatus()) + ".";
        }

        return null;
    }

    public String translateFeelingToString(Status feeling) {
        return attributeToString(feeling, Being.ATTR_HEALTH);
    }

    private static String attributeToString(Status feeling, String attributes) {
        float health = feeling.get(attributes);

        String state = "";

        if (health >= INTERVAL_HIGH) {
            state = LABEL_FINE;
        } else if (health >= INTERVAL_GOOD) {
            state = LABEL_GOOD;
        } else if (health < INTERVAL_BAD) {
            state = LABEL_BAD;
        }

        return state;
    }

    private float getHealth(Status feeling) {
        return feeling.get("health");
    }

}
