package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.knowledge.fact.frame.FrameType;
import com.harium.suneidesis.knowledge.fact.frame.FullFrame;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsciousnessSimulationTest {

    ConsciousnessSimulation alexa;
    ConsciousnessSimulation siri;

    @Before
    public void setUp() {
        alexa = new ConsciousnessSimulation("Alexa");
        alexa.setMemories(buildSelf(alexa));

        siri = new ConsciousnessSimulation("Siri");
        siri.setMemories(buildSelf(siri));
    }

    private Repository<Fact> buildSelf(Consciousness consciousness) {
        Repository<Fact> facts = new MemoryRepository<>();

        FullFrame think = new FullFrame();
        think.setSubject(consciousness);
        think.setPredicate(new Concept("think"));
        facts.add(think);

        FullFrame exists = new FullFrame();
        exists.setSubject(consciousness);
        exists.setPredicate(new Concept("exist"));
        facts.add(exists);

        FullFrame self = new FullFrame();
        self.setSubject(consciousness);
        self.setPredicate(new Concept("is"));
        self.setObject(new Concept("software"));
        facts.add(exists);

        return facts;
    }

    @Test
    public void testStorage() {
        for (Fact fact : alexa.getMemories().getAll()) {
            if (FrameType.FULL_FRAME == fact.getFrameType()) {
                FullFrame frame = (FullFrame) fact;
                if ("is".equals(frame.getPredicate())) {
                    Assert.assertEquals("software", frame.getObject());
                }
            }
        }
    }

}
