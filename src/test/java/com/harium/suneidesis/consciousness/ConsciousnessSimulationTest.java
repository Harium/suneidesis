package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.concept.numeral.Quantity;
import com.harium.suneidesis.knowledge.KnowledgeBase;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.concept.Time;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsciousnessSimulationTest {

    private KnowledgeBase alexa;
    private KnowledgeBase siri;

    @Before
    public void setUp() {
        alexa = new KnowledgeBase("Alexa");
        alexa.setFacts(buildSelf(alexa));

        siri = new KnowledgeBase("Siri");
        siri.setFacts(buildSelf(siri));
    }

    private Repository<Fact> buildSelf(KnowledgeBase consciousness) {
        Repository<Fact> facts = new MemoryRepository<>();

        Concept life = new Concept("life");
        Action think = new Action("think");
        Action exist = new Action("exist");

        Concept software = new Concept("software");
        Concept robot = new Concept("robot");
        robot.is(software)
                .can(think)
                .can(exist)
                .hasNo(life);

        Concept internet = new Concept("Internet");
        Concept data = new Concept("data");
        Action dataTransfer = new Action("data transfer");
        Concept searchEngine = new Concept("search engine");
        searchEngine.is(software);
        searchEngine.has(data, new Quantity("a lot"));

        consciousness.is(robot);

        Concept robot1 = new Concept("robot 1");
        robot1.is(robot);

        Place river = new Place("river");
        Place land = new Place("land");

        // Fact 1: The robot 1 was at the river yesterday
        Fact fact1 = new Fact();
        fact1.source(searchEngine)
                .acquisitionMedium(internet)
                .acquisitionMethod(dataTransfer)
                .subject(robot1)
                .time(Time.YESTERDAY)
                .place(river);
        facts.set("fact1", fact1);

        // Fact 2: The robot 1 is at the river now
        Fact fact2 = new Fact();
        fact2.source(searchEngine)
                .acquisitionMedium(internet)
                .acquisitionMethod(dataTransfer)
                .subject(robot1)
                .time(Time.NOW)
                .place(land);
        facts.set("fact2", fact2);

        return facts;
    }

    @Test
    public void testQuery() {
        List<Fact> robot1Facts = alexa.query("robot 1");
        assertEquals(2, robot1Facts.size());
    }

}
