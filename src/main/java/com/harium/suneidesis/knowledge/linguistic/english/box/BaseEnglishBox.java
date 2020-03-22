package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.chat.box.BaseChatBox;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public class BaseEnglishBox extends BaseChatBox {

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
    public void input(InputContext input, Output output) {
        super.input(input, output);
    }

    public static boolean checkAction(String action, String... verbs) {
        for (String verb : verbs) {
            if (action.equalsIgnoreCase(verb)) {
                return true;
            }
        }
        return false;
    }
}
