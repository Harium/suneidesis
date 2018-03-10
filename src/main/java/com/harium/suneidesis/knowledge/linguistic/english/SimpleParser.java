package com.harium.suneidesis.knowledge.linguistic.english;

import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.linguistic.core.action.ActionParser;
import com.harium.suneidesis.knowledge.linguistic.core.adjective.AdjectiveParser;
import com.harium.suneidesis.knowledge.linguistic.core.feeling.FeelingParser;
import com.harium.suneidesis.knowledge.linguistic.english.action.SimpleActionParser;
import com.harium.suneidesis.knowledge.linguistic.english.feeling.SimpleFeelingParser;

public class SimpleParser implements Parser {

    public static final String[] TO_BE = {"is", "are"};

    public static final String DID = "did";

    public static final String WHO = "who";

    public static final String HOW = "how";
    public static final String YOU = "you";

    private FeelingParser feelingParser = new SimpleFeelingParser();

    private FamilyTreeParser familyTreeParser = new FamilyTreeParser();

    private ActionParser actionParser = new SimpleActionParser();

    private AdjectiveParser adjectiveParser = new SimpleAdjectiveParser();

    public SimpleParser() {
        super();
    }

    @Override
    public String parse(String query, Being being) {

        String[] parts = query.replaceAll("\\?", "").split(" ");

        String response = null;

        if (BaseParser.checkAction(parts[0], HOW)) {
            response = feelingParser.parse(query, being);
        } else if (BaseParser.checkAction(parts[0], WHO)) {
            response = familyTreeParser.parse(query, being);
        } else if (BaseParser.checkAction(parts[0], DID)) {
            response = actionParser.parse(query, being);
        } else if (BaseParser.checkAction(parts[0], TO_BE)) {
            response = adjectiveParser.parse(query, being);
        }

        if (response == null) {
            response = BaseParser.I_DON_T_KNOW;
        }

        return response;
    }

}
