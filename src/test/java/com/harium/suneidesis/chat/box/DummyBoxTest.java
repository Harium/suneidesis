package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.instance.LanguageBox;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.chat.output.OutputContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.harium.suneidesis.chat.box.BoxTextUtils.context;

public class DummyBoxTest {

    private DummyBox box;

    @Before
    public void setUp() {
        box = new DummyBox();
    }

    @Test
    public void testAnswers() {
        LanguageBox instance = null;

        Out output = new Out();

        box.parse(context("How are you?"), output);
        Assert.assertEquals("", output.answer);

        box.parse(context("What's your name?"), output);
        Assert.assertEquals("", output.answer);

        box.parse(context("Tell me more about the Theory of Relativity"), output);
        Assert.assertEquals("", output.answer);

        box.parse(context("Thank you for listen to me"), output);
        Assert.assertEquals("", output.answer);
    }

    class Out implements Output {
        public String answer = "";

        @Override
        public void print(String sentence, OutputContext context) {
            this.answer = sentence;
        }

        @Override
        public void produceFile(String path, String description) {
            this.answer = path;
        }
    }
}
