package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.chat.input.InputContext;

import static com.harium.suneidesis.beign.chat.LanguageBoxBeing.PARAM_BEING;

public abstract class BeingParser {
    protected Being getBeing(InputContext context) {
        if (!context.getProperties().containsKey(PARAM_BEING)) {
            return null;
        }

        return (Being) context.getProperties().get(PARAM_BEING);
    }
}
