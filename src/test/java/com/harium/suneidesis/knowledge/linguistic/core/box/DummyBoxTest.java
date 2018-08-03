package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyBoxTest {

    private DummyBox box;

    @Before
    public void setUp() {
        box = new DummyBox();
    }

    @Test
    public void testAnswers() {
        Instance instance = null;
        Assert.assertEquals("", box.input("How are you?", instance));
        Assert.assertEquals("", box.input("What's your name?", instance));
        Assert.assertEquals("", box.input("Tell me more about the Theory of Relativity", instance));
        Assert.assertEquals("", box.input("Thank you for listen to me", instance));
    }

}
