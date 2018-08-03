package examples;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;
import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.Place;
import com.harium.suneidesis.knowledge.linguistic.core.box.EchoBox;
import com.harium.suneidesis.knowledge.linguistic.core.box.LanguageBox;
import com.harium.suneidesis.knowledge.storage.Fact;
import com.harium.suneidesis.knowledge.storage.frame.FullFrame;
import com.harium.suneidesis.knowledge.time.TemporalConcept;
import com.harium.suneidesis.knowledge.time.Time;
import com.harium.suneidesis.knowledge.weather.Weather;

import java.util.ArrayList;
import java.util.List;

public class ParrotReasoner {

    public static void main(String[] args) {
        LanguageBox echo = new EchoBox();

        Instance parrot = new Instance("Parrot", Gender.MALE);
        parrot.setLanguageBox(echo);

        createMemories(parrot);

        ask("How are you?", parrot);
        ask("Who is your father?", parrot);
        ask("Did you cut something else?", parrot);
        ask("Did you heard something about cut?", parrot);
        ask("Did you heard something about Sauron?", parrot);
    }

    public static List<Fact> createMemories(Instance beign) {

        List<Fact> memories = new ArrayList<Fact>();

        FullFrame born = new FullFrame();
        born.setActor(beign);
        born.setWhen(new TemporalConcept("TA 2644", Time.PAST));
        memories.add(born);

        FullFrame killTroll = new FullFrame();

        killTroll.setActor(beign); //Who did the action
        killTroll.setTarget(new Being("a Troll")); //Who suffered the action (target)
        killTroll.setPlace(new Place("at the top of").at(new Place("Silvertine"))); //Where the action happens
        killTroll.setAction(new Concept("Cut")); //Action's name
        killTroll.setWhereInTarget(new Concept("throat")); // Where in the target the action happened
        killTroll.setWhen(new TemporalConcept("last week", Time.PAST)); //When action happens

        List<Fact> conclusions = new ArrayList<Fact>();
        FullFrame beingKilledTroll = new FullFrame();
        beingKilledTroll.setActor(beign);
        beingKilledTroll.setAction(new Concept("Kill"));
        beingKilledTroll.setTarget(new Being("a Troll"));

        conclusions.add(beingKilledTroll);
        killTroll.setConclusions(conclusions);

        memories.add(killTroll);

        FullFrame createRing = new FullFrame();

        createRing.setActor(new Being("Sauron")); //Who did the action
        createRing.setTarget(new Being("a ring")); //Who suffered the action
        createRing.setPlace(new Place("somewhere in").at(new Place("Middle-Earth"))); //Where the action happens
        createRing.setAction(new Concept("Create")); //Action's name
        createRing.setWhereInTarget(null); //
        createRing.setWhen(new TemporalConcept("many years ago", Time.PAST)); //When action happened

        memories.add(createRing);

        //Fact summerRain = new Fact();
        //summerRain.setPlace(place);

        FullFrame batExists = new FullFrame();
        batExists.setActor(new Being("bats"));
        batExists.setAction(new Concept("Exist"));

        memories.add(batExists);

        FullFrame cowIsMammal = new FullFrame();
        cowIsMammal.setActor(new Being("cow"));
        cowIsMammal.setAction(new Concept("is"));
        cowIsMammal.setTarget(new Concept("mammal"));

        memories.add(cowIsMammal);

        FullFrame summerRain = new FullFrame();
        summerRain.setPlace(new Place("here"));
        summerRain.setWhen(TemporalConcept.NOW);
        summerRain.setWeather(Weather.RAINY);

        return memories;
    }

    private static void ask(String query, Instance beign) {
        System.out.println(query + " (" + beign.getName() + ")");
        beign.output(beign.input(query));
    }

}
