package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.knowledge.linguistic.core.matcher.Eq;
import com.harium.suneidesis.knowledge.linguistic.core.matcher.Or;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.LowerCaseTokenizer;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.Tokenizer;

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
    public void parse(InputContext context, Output output) {
        output.print(context.getSentence());
    }

}
