package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;

public class GreetingsParser implements Parser {

    public static final String[] GREETINGS = new String[]{"hi", "hello"};

    @Override
    public boolean matches(String query) {
        String[] parts = query.split(" ");

        for (String text : GREETINGS) {
            if (parts[0].toLowerCase().startsWith(text)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String parse(String query, Instance beign) {
        return query;
    }

}
