package com.harium.suneidesis.knowledge.linguistic.english.feeling;

import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.beign.Status;
import com.harium.suneidesis.knowledge.linguistic.core.feeling.FeelingParser;

public class SimpleFeelingParser implements FeelingParser {

    private float fineInterval = 0.90f;

    private float goodInterval = 0.75f;

    private float badInterval = 0.50f;

    @Override
    public String parse(String query, Being beign) {
        if (query.contains("You")) {
            return "I am " + translateFeelingToString(beign.getStatus()) + ".";
        }

        return null;
    }

    public String translateFeelingToString(Status feeling) {
        float health = getHealth(feeling);

        String state = "";

        if (health >= fineInterval) {
            state = "Fine";
        } else if (health >= goodInterval) {
            state = "Good";
        } else if (health < badInterval) {
            state = "Bad";
        }

        return state;

    }

    private float getHealth(Status feeling) {
        return feeling.get("health");
    }

}
