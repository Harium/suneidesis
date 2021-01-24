package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.concept.numeral.Measure;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.concept.Time;
import com.harium.suneidesis.repository.MemoryRepository;
import com.harium.suneidesis.repository.Search;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsciousnessSimulationTest {

    private KnowledgeBase alexa;
    private KnowledgeBase siri;

    @Before
    public void setUp() {
        alexa = new MemoryRepository("Alexa");
        buildSelf(alexa);

        siri = new MemoryRepository("Siri");
        buildSelf(siri);
    }

    private void buildSelf(KnowledgeBase consciousness) {
        Concept life = new Concept("life");
        Action think = new Action("think");
        Action exist = new Action("exist");

        Concept software = new Concept("software");
        Concept robot = new Concept("robot");
        robot.is(software)
                .can(think)
                .can(exist)
                .hasNoQuantity(life);

        Concept myself = new Concept("me");
        myself.is(robot);
        Fact autoKnowledge = new Fact();
        autoKnowledge.subject(myself);
        consciousness.set("myself", autoKnowledge);

        Concept internet = new Concept("Internet");
        Concept data = new Concept("data");
        Action dataTransfer = new Action("data transfer");
        Concept searchEngine = new Concept("search engine");
        searchEngine.is(software);
        searchEngine.hasQuantity(data, new Measure("a lot"));

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
        consciousness.set("fact1", fact1);

        // Fact 2: The robot 1 is at the river now
        Fact fact2 = new Fact();
        fact2.source(searchEngine)
                .acquisitionMedium(internet)
                .acquisitionMethod(dataTransfer)
                .subject(robot1)
                .time(Time.NOW)
                .place(land);
        consciousness.set("fact2", fact2);
    }

    @Test
    public void testQuery() {
        Search search = new Search();
        search.term = "robot 1";
        List<Fact> robot1Facts = alexa.query(search);
        assertEquals(2, robot1Facts.size());
    }

}
