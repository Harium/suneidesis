package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.linguistic.core.matcher.Any;
import com.harium.suneidesis.knowledge.linguistic.core.tokenization.BaseTokenizer;
import com.harium.suneidesis.knowledge.linguistic.core.tokenization.LowerCaseTokenizer;
import com.harium.suneidesis.knowledge.linguistic.core.tokenization.Tokenizer;

public class GreetingsParser implements Parser {

    public static final String[] GREETINGS = new String[]{"hi", "hello"};
    private Tokenizer tokenizer;
    private Any greetingsMatcher = new Any(GREETINGS);

    public GreetingsParser() {
        tokenizer = new LowerCaseTokenizer();
    }

    @Override
    public boolean matches(String query) {
        String[] tokens = tokenizer.tokenize(query);
        return greetingsMatcher.matches(tokens);
    }

    @Override
    public String parse(String query, Instance beign) {
        return query;
    }

}
