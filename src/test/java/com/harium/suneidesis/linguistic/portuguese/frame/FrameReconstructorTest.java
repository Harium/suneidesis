package com.harium.suneidesis.linguistic.portuguese.frame;

import com.harium.suneidesis.linguistic.fact.Reconstructor;
import org.junit.Before;

public class FrameReconstructorTest {

    private Reconstructor reconstructor;

    @Before
    public void setUp() {
        reconstructor = new FrameReconstructor();
    }

   /* @Test
    public void testNounReconstruction() {
        String sentence = "o gato";

        WordNoun subject = new WordNoun("gato");
        subject.setGender(WordNoun.GENDER_MASCULINE);

        Fact fact = new Fact();
        fact.subject(subject);

        String reconstructed = reconstructor.reconstruct(fact);
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
    }*/

}
