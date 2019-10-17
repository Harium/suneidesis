package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.knowledge.fact.frame.FrameType;
import com.harium.suneidesis.knowledge.fact.frame.FullFrame;
import com.harium.suneidesis.knowledge.storage.MemoryStorage;
import com.harium.suneidesis.knowledge.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    private Storage<Fact> buildSelf(Consciousness consciousness) {
        Storage<Fact> facts = new MemoryStorage<>();

        FullFrame think = new FullFrame();
        think.setActor(consciousness);
        think.setAction(new Concept("think"));
        facts.add(think);

        FullFrame exists = new FullFrame();
        exists.setActor(consciousness);
        exists.setAction(new Concept("exist"));
        facts.add(exists);

        FullFrame self = new FullFrame();
        self.setActor(consciousness);
        self.setAction(new Concept("is"));
        self.setTarget(new Concept("software"));
        facts.add(exists);

        return facts;
    }

    @Test
    public void testStorage() {
        for (Fact fact : alexa.getMemories().getAll()) {
            if (FrameType.FULL_FRAME == fact.getFrameType()) {
                FullFrame frame = (FullFrame) fact;
                if ("is".equals(frame.getAction())) {
                    Assert.assertEquals("software", frame.getTarget());
                }
            }
        }
    }

}
