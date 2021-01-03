package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.knowledge.fact.frame.FrameType;
import com.harium.suneidesis.knowledge.fact.frame.FullFrame;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsciousnessSimulationTest {

    /*Concept alexa;
    Concept siri;

    @Before
    public void setUp() {
        alexa = new Concept("Alexa");
        alexa.setMemories(buildSelf(alexa));

        siri = new Concept("Siri");
        siri.setMemories(buildSelf(siri));
    }

    private Repository<Fact> buildSelf(Concept consciousness) {
        Repository<Fact> facts = new MemoryRepository<>();

        FullFrame think = new FullFrame();
        think.setSubject(consciousness);
        think.setPredicate(new Concept("think"));
        facts.set(think);

        FullFrame exists = new FullFrame();
        exists.setSubject(consciousness);
        exists.setPredicate(new Concept("exist"));
        facts.set(exists);

        FullFrame self = new FullFrame();
        self.setSubject(consciousness);
        self.setPredicate(new Concept("is"));
        self.setObject(new Concept("software"));
        facts.set(exists);

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
    }*/

}
