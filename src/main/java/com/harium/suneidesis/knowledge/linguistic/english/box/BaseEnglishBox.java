package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.box.BaseLanguageBox;
import com.harium.suneidesis.output.Output;

public class BaseEnglishBox extends BaseLanguageBox {

    public static final String I_DON_T_KNOW = "I don't know.";

    public BaseEnglishBox() {
        super();

        // Greetings
        parsers.add(new GreetingsParser());

        // How
        //parsers.add(new SimpleFeelingParser());

        // Who
        parsers.add(new FamilyTreeParser());

        // Did
        parsers.add(new SimpleActionParser());

        // To be
        //parsers.add(new SimpleAdjectiveParser());
    }

    @Override
    public void input(String sentence, Instance instance, Output output) {
        super.input(sentence, instance, output);
    }

    public static boolean checkAction(String action, String ... verbs) {
        for (String verb : verbs) {
            if (action.equalsIgnoreCase(verb)) {
                return true;
            }
        }
        return false;
    }
}
