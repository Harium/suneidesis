package com.harium.suneidesis.concept.inspector.matchers;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GreaterThanTest {

    @Test
    public void testEvaluate() {
        GreaterThan matcher = new GreaterThan(new BigDecimal("1"));
        assertFalse(matcher.evaluate("0"));
        assertTrue(matcher.evaluate("2"));
    }

}
