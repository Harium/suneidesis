package examples;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.box.DummyBox;
import com.harium.suneidesis.knowledge.linguistic.core.box.LanguageBox;

public class SpongeReasoner {

    public static void main(String[] args) {
        LanguageBox box = new DummyBox();

        Instance sponge = new Instance("Sponge");
        sponge.setLanguageBox(box);

        TaxonomyReasoner.createMemories(sponge);

        ask("How are you?", sponge);
        ask("Who is your father?", sponge);
        ask("Did you cut something else?", sponge);
        ask("Did you heard something about cut?", sponge);
        ask("Did you heard something about Sauron?", sponge);
    }

    private static void ask(String query, Instance beign) {
        System.out.println(query + " (" + beign.getName() + ")");
        beign.output(beign.input(query));
    }

}
