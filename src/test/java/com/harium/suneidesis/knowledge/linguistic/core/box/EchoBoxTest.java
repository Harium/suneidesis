package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.output.Output;
import com.harium.suneidesis.output.OutputContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EchoBoxTest {

    private EchoBox box;

    @Before
    public void setUp() {
        box = new EchoBox();
    }

    @Test
    public void testAnswers() {
        Instance instance = null;

        Out output = new Out();

        box.input("How are you?", instance, output);
        Assert.assertEquals("How are you?", output.answer);

        box.input("What's your name?", instance, output);
        Assert.assertEquals("What's your name?", output.answer);

        box.input("Tell me more about the Theory of Relativity", instance, output);
        Assert.assertEquals("Tell me more about the Theory of Relativity", output.answer);

        box.input("Thank you for listen to me", instance, output);
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
