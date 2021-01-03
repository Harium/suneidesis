package com.harium.suneidesis.chat.being;

import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.chat.box.ChatBox;
import com.harium.suneidesis.chat.box.DummyBox;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.instance.LanguageBox;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.chat.output.TextOutput;

public class LanguageBoxBeing extends Being implements LanguageBox {

    public static final String PARAM_BEING = "beign";
    public static final String PARAM_INSTANCE = "instance";

    private Identity identity;

    private ChatBox chatBox = new DummyBox();

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

    public void input(InputContext context, Output output) {
        context.getProperties().put(PARAM_INSTANCE, this);
        chatBox.input(context, output);
    }

    public ChatBox getChatBox() {
        return chatBox;
    }

    public void setChatBox(ChatBox chatBox) {
        this.chatBox = chatBox;
    }

    @Override
    public void input(InputContext context, TextOutput output) {

    }
}
