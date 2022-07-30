package com.harium.suneidesis.chat.being;

import com.harium.suneidesis.concept.beign.Identity;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.chat.box.DummyBox;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.instance.LanguageBox;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.chat.output.TextOutput;

public class LanguageBoxBeing extends Being implements LanguageBox {

    public static final String PARAM_BEING = "beign";
    public static final String PARAM_INSTANCE = "instance";

    private Identity identity;

    private Parser parser = new DummyBox();

    public LanguageBoxBeing(Identity identity) {
        super(identity.getName());
        this.identity = identity;
    }

    public LanguageBoxBeing(Identity identity, Concept gender) {
        super(identity.getName(), gender);
        this.identity = identity;
    }

    public LanguageBoxBeing(String name) {
        super(name);
        this.identity = new Identity(name);
    }

    public LanguageBoxBeing(String name, Concept gender) {
        super(name, gender);
        this.identity = new Identity(name);
    }

    public boolean parse(InputContext context, Output output) {
        context.getProperties().put(PARAM_INSTANCE, this);
        return parser.parse(context, output);
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void input(InputContext context, TextOutput output) {

    }
}
