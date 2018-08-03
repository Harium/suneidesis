package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
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
        Assert.assertEquals("How are you?", box.input("How are you?", instance));
        Assert.assertEquals("What's your name?", box.input("What's your name?", instance));
        Assert.assertEquals("Tell me more about the Theory of Relativity", box.input("Tell me more about the Theory of Relativity", instance));
        Assert.assertEquals("Thank you for listen to me", box.input("Thank you for listen to me", instance));
    }

}
