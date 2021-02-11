package examples.shopping;

import com.harium.suneidesis.chat.input.Terminal;

public class ShoppingListExample {

    public static void main(String[] args) {
        CustomTerminal terminal = new CustomTerminal();
        terminal.addParser(new ShoppingListParser());

        // Example sentences
        terminal.input("Can you please add tomato to my shopping list?");
        terminal.input("please add apple juice to the shopping list?");
        terminal.input("Add onions to the list?");

        terminal.input("What do I have in the shopping list?");
    }

    static class CustomTerminal extends Terminal {
        @Override
        public void input(String sentence) {
            super.input(sentence);
        }
    }

}
