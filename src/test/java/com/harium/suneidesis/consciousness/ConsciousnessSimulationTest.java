package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.storage.Fact;
import com.harium.suneidesis.knowledge.storage.frame.FrameType;
import com.harium.suneidesis.knowledge.storage.frame.FullFrame;
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

    private List<Fact> buildSelf(Consciousness consciousness) {
        List<Fact> facts = new ArrayList<>();

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
        for (Fact fact : alexa.getMemories()) {
            if (FrameType.FULL_FRAME == fact.getFrameType()) {
                FullFrame frame = (FullFrame) fact;
                if ("is".equals(frame.getAction())) {
                    Assert.assertEquals("software", frame.getTarget());
                }
            }
        }
    }

}
