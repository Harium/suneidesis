import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;
import com.harium.suneidesis.beign.ancestry.HeteroSexualCouple;
import com.harium.suneidesis.instance.Instance;
import examples.TaxonomyReasoner;


public class Terminal {

    public static void main(String[] args) {

        Instance thrain = new Instance("Thrain", Gender.MALE);

        Instance thror = new Instance("Thror", Gender.MALE);

        HeteroSexualCouple thrainsParents = new HeteroSexualCouple(thror, new Being("?"));
        thrain.setAncestry(thrainsParents);

        thrain.setMemories(TaxonomyReasoner.createMemories(thror));

        ask("How are You?", thrain);

        ask("Who is your father?", thrain);

        ask("Who is your father?", thror);

        ask("Did you cut something else?", thrain);

        ask("Did you heard something about cut?", thrain);

        ask("Did you heard something about Sauron?", thrain);
    }

    private static void ask(String query, Instance beign) {

        System.out.println(query.replace("?", ", " + beign.getName() + "?"));

        System.out.println(beign.input(query));
    }

}
