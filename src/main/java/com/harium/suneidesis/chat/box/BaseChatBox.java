package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.interceptor.QuestionMarkRemoverInterceptor;
import com.harium.suneidesis.chat.output.Output;

import java.util.ArrayList;
import java.util.List;

public class BaseChatBox implements Parser {

    protected Parser currentParser = null;
    protected List<Parser> parsers = new ArrayList<>();
    protected List<Interceptor> interceptors = new ArrayList<>();

    public BaseChatBox() {
        // Removes Question Mark
        interceptors.add(new QuestionMarkRemoverInterceptor());
    }

    @Override
    public boolean parse(InputContext input, Output output) {
        input.setCurrentParser(currentParser);

        interceptInput(input, output);

        return queryParsers(input, output);
    }

    private void interceptInput(InputContext input, Output output) {
        for (Interceptor interceptor : interceptors) {
            interceptor.intercept(input, output);
        }
    }

    private boolean queryParsers(InputContext context, Output output) {
        if (currentParser != null) {
            if (currentParser.parse(context, output)) {
                return true;
            }
        }

        for (Parser parser : parsers) {
            if (parser != currentParser) {
                if (parser.parse(context, output)) {
                    currentParser = parser;
                    return true;
                }
            }
        }
        return false;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void addParser(Parser parser) {
        parsers.add(parser);
    }

}
