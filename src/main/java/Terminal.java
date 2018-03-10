import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.beign.Gender;
import com.harium.suneidesis.knowledge.beign.RationalBeign;
import com.harium.suneidesis.knowledge.beign.ancestry.HeteroSexualCouple;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.Place;
import com.harium.suneidesis.knowledge.memory.Fact;
import com.harium.suneidesis.knowledge.time.TemporalConcept;
import com.harium.suneidesis.knowledge.time.Time;
import com.harium.suneidesis.knowledge.weather.Weather;
import examples.TaxonomyReasoner;

import java.util.ArrayList;
import java.util.List;


public class Terminal {

    public static void main(String[] args) {

        RationalBeign thrain = new RationalBeign("Thráin II", Gender.MALE);

        RationalBeign thror = new RationalBeign("Thrór", Gender.MALE);

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

    private static void ask(String query, RationalBeign beign) {

        System.out.println(query.replace("?", ", " + beign.getName() + "?"));

        System.out.println(beign.listen(query));
    }

}
