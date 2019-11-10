package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.input.InputContext;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.linguistic.core.matcher.Eq;
import com.harium.suneidesis.knowledge.linguistic.core.matcher.Or;
import com.harium.suneidesis.knowledge.linguistic.core.tokenization.LowerCaseTokenizer;
import com.harium.suneidesis.knowledge.linguistic.core.tokenization.Tokenizer;

public class GreetingsParser implements Parser {

    private Tokenizer tokenizer;
    private Or greetingsMatcher = new Or(new Eq("hi"), new Eq("hello"));

    public GreetingsParser() {
        tokenizer = new LowerCaseTokenizer();
    }

    @Override
    public boolean matches(InputContext context) {
        String query = context.getSentence();
        String[] tokens = tokenizer.tokenize(query);
        return greetingsMatcher.matches(tokens);
    }

    @Override
    public void parse(InputContext context) {
        context.print(context.getSentence());
    }

}
