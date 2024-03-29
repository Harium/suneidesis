package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.instance.LanguageBox;
import com.harium.suneidesis.chat.output.BaseOutput;
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

        box.parse(context("How are you?"), output);
        Assert.assertEquals("How are you?", output.answer);

        box.parse(context("What's your name?"), output);
        Assert.assertEquals("What's your name?", output.answer);

        box.parse(context("Tell me more about the Theory of Relativity"), output);
        Assert.assertEquals("Tell me more about the Theory of Relativity", output.answer);

        box.parse(context("Thank you for listen to me"), output);
        Assert.assertEquals("Thank you for listen to me", output.answer);
    }

    class Out extends BaseOutput {
        public String answer = "";

        @Override
        public void print(String sentence, OutputContext context) {
            this.answer = sentence;
        }

        @Override
        public void produceFile(byte[] data, String description) {
            this.answer = new String(data);
        }
    }
}
