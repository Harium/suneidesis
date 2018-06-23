package com.harium.suneidesis.knowledge.linguistic.portuguese.frame;

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
        String sentence = "o gato";

        NounFrame subject = new NounFrame(sentence.split(" ")[1]);
        subject.setDeterminer(sentence.split(" ")[0]);

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(sentence, reconstructed);
    }

    @Test
    public void testNounWithAdjectiveReconstruction() {
        String sentence = "o gato grande";

        NounFrame subject = new NounFrame(sentence.split(" ")[1]);
        subject.setDeterminer(sentence.split(" ")[0]);
        subject.addAdjective(new AdjectiveFrame(sentence.split(" ")[2]));

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(sentence, reconstructed);
    }

    @Test
    public void testNounWithMultipleAdjectives() {
        String sentence = "o gato amarelo, grande e peludo";

        NounFrame subject = new NounFrame(sentence.split(" ")[1]);
        subject.setDeterminer(sentence.split(" ")[0]);
        subject.addAdjective(new AdjectiveFrame("amarelo"));
        subject.addAdjective(new AdjectiveFrame("grande"));
        subject.addAdjective(new AdjectiveFrame("peludo"));

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(sentence, reconstructed);
    }

    @Test
    public void testNounWithAdjectiveAndAdverbReconstruction() {
        String sentence = "o gato muito grande";

        NounFrame subject = new NounFrame(sentence.split(" ")[1]);
        subject.setDeterminer(sentence.split(" ")[0]);
        subject.addAdjective(new AdjectiveFrame("muito", "grande"));

        BaseFrame frame = new BaseFrame();
        frame.setNoun(subject);

        String reconstructed = reconstructor.reconstruct(frame);
        Assert.assertEquals(sentence, reconstructed);
    }

}
