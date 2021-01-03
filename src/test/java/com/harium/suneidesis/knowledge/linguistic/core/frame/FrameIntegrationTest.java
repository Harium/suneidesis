package com.harium.suneidesis.knowledge.linguistic.core.frame;

import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.knowledge.context.ConversationContext;
import com.harium.suneidesis.knowledge.time.TemporalConcept;
import org.junit.Assert;
import org.junit.Test;

public class FrameIntegrationTest {

    @Test
    public void testNounStructureWithConversationContext() {
        Being speaker = new Being("Alice");
        speaker.setId("alice");

        ConversationContext context = new ConversationContext(TemporalConcept.NOW);
        context.getParticipants().set(speaker.getId(), speaker);

        // A tuple
        String sentence = "I am happy";

        String adjective = sentence.split(" ")[2];
        AdjectiveFrame adjectiveFrame = new AdjectiveFrame(adjective);

        Concept firstParticipant = context.getParticipantsAsList().iterator().next();
        Being i = new Being(firstParticipant.getName());

        NounFrame noun = new NounFrame(i, adjectiveFrame);

        BaseFrame frame = new BaseFrame();
        frame.setNoun(noun);

        Assert.assertEquals(speaker.getName(), noun.noun.getName());
        Assert.assertEquals(adjective, noun.adjectives.get(0).adjective.getName());
    }

    @Test
    public void testAdjectiveStructure() {
        String sentence = "the big cat jumped at a leaf";

        // Conversation Subject
        Being subject = new Being("cat");

        // Actor
        NounFrame noun = new NounFrame(subject);
        noun.setArticle("the");
        noun.addAdjective(new AdjectiveFrame("big"));

        // Object
        NounFrame object = new NounFrame("leaf");
        object.setArticle("a");

        String action = sentence.split(" ")[3];
        ActionFrame actionFrame = new ActionFrame(action, object);

        BaseFrame frame = new BaseFrame();
        frame.setNoun(noun);
        frame.setAction(actionFrame);

        Assert.assertEquals("cat", noun.noun.getName());
        Assert.assertEquals("big", noun.adjectives.get(0).adjective.getName());
        Assert.assertEquals("jumped", frame.getAction().action.getName());
    }

}
