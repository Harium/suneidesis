package com.harium.suneidesis.knowledge.linguistic.core.nlp;

import com.harium.suneidesis.knowledge.linguistic.core.frame.AdjectiveFrame;
import com.harium.suneidesis.knowledge.linguistic.core.frame.BaseFrame;
import com.harium.suneidesis.knowledge.linguistic.core.frame.NounFrame;
import com.harium.suneidesis.knowledge.linguistic.core.frame.Reconstructor;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.POSTaggerReconstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class POSTaggerReconstructorTest {

    private Reconstructor reconstructor;

    @Before
    public void setUp() {
        reconstructor = new POSTaggerReconstructor();
    }

    @Test
    public void testNounReconstruction() {
        String sentence = "the cat";
        String taggedSentence = "the/DT cat/NN";

        NounFrame subject = new NounFrame(sentence.split(" ")[1]);
        subject.setDeterminer("the");

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(taggedSentence, reconstructed);
    }

    @Test
    public void testNounWithAdjectiveReconstruction() {
        String sentence = "the big cat";
        String taggedSentence = "the/DT big/JJ cat/NN";

        NounFrame subject = new NounFrame(sentence.split(" ")[2]);
        subject.setDeterminer("the");
        subject.addAdjective(new AdjectiveFrame("big"));

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(taggedSentence, reconstructed);
    }

    @Test
    public void testNounWithAdjectiveAndAdverbReconstruction() {
        String sentence = "the very big cat";
        String taggedSentence = "the/DT very/RB big/JJ cat/NN";

        NounFrame subject = new NounFrame(sentence.split(" ")[3]);
        subject.setDeterminer("the");
        subject.addAdjective(new AdjectiveFrame("very", "big"));

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(taggedSentence, reconstructed);
    }

}
