package com.harium.suneidesis.knowledge.linguistic.english.frame;

import com.harium.suneidesis.knowledge.linguistic.core.frame.AdjectiveFrame;
import com.harium.suneidesis.knowledge.linguistic.core.frame.BaseFrame;
import com.harium.suneidesis.knowledge.linguistic.core.frame.NounFrame;
import com.harium.suneidesis.knowledge.linguistic.core.frame.Reconstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameReconstructorTest {

    private Reconstructor reconstructor;

    @Before
    public void setUp() {
        reconstructor = new FrameReconstructor();
    }

    @Test
    public void testNounReconstruction() {
        String sentence = "the cat";

        NounFrame subject = new NounFrame(sentence.split(" ")[1]);
        subject.setDeterminer(sentence.split(" ")[0]);

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(sentence, reconstructed);
    }

    @Test
    public void testNounWithAdjectiveReconstruction() {
        String sentence = "the big cat";

        NounFrame subject = new NounFrame(sentence.split(" ")[2]);
        subject.setDeterminer("the");
        subject.addAdjective(new AdjectiveFrame("big"));

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(sentence, reconstructed);
    }

    @Test
    public void testNounWithAdjectiveAndAdverbReconstruction() {
        String sentence = "the very big cat";

        NounFrame subject = new NounFrame(sentence.split(" ")[3]);
        subject.setDeterminer("the");
        subject.addAdjective(new AdjectiveFrame("very", "big"));

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(sentence, reconstructed);
    }

}
