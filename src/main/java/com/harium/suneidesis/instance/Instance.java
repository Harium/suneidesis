package com.harium.suneidesis.instance;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;
import com.harium.suneidesis.knowledge.linguistic.core.box.DummyBox;
import com.harium.suneidesis.knowledge.linguistic.core.box.LanguageBox;
import com.harium.suneidesis.output.Output;

public class Instance extends Being {

    private Identity identity;
    //private Context context;

    private LanguageBox languageBox = new DummyBox();

    public Instance(Identity identity) {
        super(identity.getName());
        this.identity = identity;
    }

    public Instance(Identity identity, Gender gender) {
        super(identity.getName(), gender);
        this.identity = identity;
    }

    public Instance(String name) {
        super(name);
        this.identity = new Identity(name);
    }

    public Instance(String name, Gender gender) {
        super(name, gender);
        this.identity = new Identity(name);
    }

    public void input(String sentence, Output output) {
        languageBox.input(sentence, this, output);
    }

    public LanguageBox getLanguageBox() {
        return languageBox;
    }

    public void setLanguageBox(LanguageBox languageBox) {
        this.languageBox = languageBox;
    }
}
