import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;
import com.harium.suneidesis.beign.ancestry.HeteroSexualCouple;
import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.box.LanguageBox;
import com.harium.suneidesis.knowledge.linguistic.english.box.BaseEnglishBox;
import examples.TaxonomyReasoner;

import java.util.Scanner;


public class Terminal {

    public static final String EXIT_COMMAND = "quit";

    public static Instance thrain;

    public static void main(String[] args) {

        LanguageBox language = new BaseEnglishBox();

        thrain = new Instance("Thrain", Gender.MALE);
        thrain.setLanguageBox(language);

        Instance thror = new Instance("Thror", Gender.MALE);
        thror.setLanguageBox(language);

        HeteroSexualCouple thrainsParents = new HeteroSexualCouple(thror, new Being(""));
        thrain.setAncestry(thrainsParents);

        thrain.setMemories(TaxonomyReasoner.createMemories(thror));

        System.out.println("Ask something using the keyboard (type " + EXIT_COMMAND + " to exit):");
        readKeyboard();
    }

    private static void readKeyboard() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            ask(line, thrain);
            if (EXIT_COMMAND.equals(line)) {
                break;
            }
        }
        System.out.println("Bye.");
    }

    private static void ask(String query, Instance beign) {
        beign.output(beign.input(query));
    }

}
