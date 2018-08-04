package examples;

import com.harium.suneidesis.beign.Gender;
import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.box.EchoBox;
import com.harium.suneidesis.knowledge.linguistic.core.box.LanguageBox;

public class ParrotReasoner {

    public static void main(String[] args) {
        LanguageBox echo = new EchoBox();

        Instance parrot = new Instance("Parrot", Gender.MALE);
        parrot.setLanguageBox(echo);

        TaxonomyReasoner.createMemories(parrot);

        ask("How are you?", parrot);
        ask("Who is your father?", parrot);
        ask("Did you cut something else?", parrot);
        ask("Did you heard something about cut?", parrot);
        ask("Did you heard something about Sauron?", parrot);
    }

    private static void ask(String query, Instance beign) {
        System.out.println(query + " (" + beign.getName() + ")");
        beign.output(beign.input(query));
    }

}
