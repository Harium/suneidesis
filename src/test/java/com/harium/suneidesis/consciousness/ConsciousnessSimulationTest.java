package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.concept.*;
import com.harium.suneidesis.concept.measurement.Measurement;
import com.harium.suneidesis.concept.helper.Provenance;
import com.harium.suneidesis.concept.time.Time;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.nitrite.RepositoryConceptCursor;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import org.junit.Before;
import org.junit.Test;

import static org.dizitart.no2.filters.Filters.eq;
import static org.junit.Assert.assertEquals;

public class ConsciousnessSimulationTest {

    private MemoryKnowledgeBase alexa;
    private MemoryKnowledgeBase siri;

    @Before
    public void setUp() {
        alexa = new MemoryKnowledgeBase("Alexa");
        buildSelf(alexa);

        siri = new MemoryKnowledgeBase("Siri");
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
        Concept autoKnowledge = new Concept("auto knowledge");
        Provenance.setSubject(autoKnowledge, myself);
        consciousness.save(KnowledgeBase.SELF, autoKnowledge);

        Concept internet = new Concept("Internet");
        Concept data = new Concept("data");
        Action dataTransfer = new Action("data transfer");
        Concept searchEngine = new Concept("search engine");
        searchEngine.is(software);
        searchEngine.hasQuantity(data, new Measurement().value("a lot"));

        Concept robot1 = new Concept("robot 1");
        robot1.is(robot);

        Place river = new Place("river");
        Place land = new Place("land");

        // Fact 1: The robot 1 was at the river yesterday
        Concept fact1 = new Concept("fact1");
        Provenance fact1Wrapper = new Provenance(fact1);
        fact1Wrapper.source(searchEngine)
                .acquisitionMedium(internet)
                .acquisitionMethod(dataTransfer)
                .subject(robot1)
                .time(Time.YESTERDAY)
                .place(river);
        consciousness.save(fact1);

        // Fact 2: The robot 1 is at the river now
        Concept fact2 = new Concept("fact2");
        Provenance fact2Wrapper = new Provenance(fact2);
        fact2Wrapper.source(searchEngine)
                .acquisitionMedium(internet)
                .acquisitionMethod(dataTransfer)
                .subject(robot1)
                .time(Time.NOW)
                .place(land);
        consciousness.save(fact2);
    }

    @Test
    public void testFind() {
        RepositoryConceptCursor cursor = alexa.find(eq("subject.name", "robot 1"));
        assertEquals(2, cursor.size());

        Concept concept = cursor.firstOrDefault();
        assertEquals("fact1", concept.getName());
    }

}
