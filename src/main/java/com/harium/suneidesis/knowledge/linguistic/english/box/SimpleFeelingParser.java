package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Status;
import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.feeling.FeelingParser;

public class SimpleFeelingParser implements FeelingParser {

    public static final String HOW = "how";

    private static final float interval = Status.MAX / 5;
    private static final float INTERVAL_HIGH = interval * 4; // 80%
    private static final float INTERVAL_GOOD = interval * 3; // 60%
    private static final float INTERVAL_BAD = Status.NEUTRAL; // 50%

    private static final String LABEL_FINE = "fine";
    private static final String LABEL_GOOD = "good";
    private static final String LABEL_BAD = "bad";

    @Override
    public boolean matches(String query) {
        String[] parts = query.split(" ");
        return BaseEnglishBox.checkAction(parts[0], HOW);
    }

    @Override
    public String parse(String query, Instance beign) {
        Being target;
        if (query.contains("You")||query.contains("you")) {
            target = beign;
            return "I am " + translateFeelingToString(target.getStatus()) + ".";
        }

        return "";
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
