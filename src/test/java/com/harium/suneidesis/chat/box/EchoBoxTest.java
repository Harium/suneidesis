package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.instance.LanguageBox;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.chat.output.OutputContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.harium.suneidesis.chat.box.BoxTextUtils.context;

public class EchoBoxTest {

    private EchoBox box;

    @Before
    public void setUp() {
        box = new EchoBox();
    }

    @Test
    public void testAnswers() {
        LanguageBox instance = null;

        Out output = new Out();

        box.input(context("How are you?"), output);
        Assert.assertEquals("How are you?", output.answer);

        box.input(context("What's your name?"), output);
        Assert.assertEquals("What's your name?", output.answer);

        box.input(context("Tell me more about the Theory of Relativity"), output);
        Assert.assertEquals("Tell me more about the Theory of Relativity", output.answer);

        box.input(context("Thank you for listen to me"), output);
        Assert.assertEquals("Thank you for listen to me", output.answer);
    }

    class Out implements Output {
        public String answer;

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
