package com.harium.suneidesis.concept.helper.matchers;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LowerThanTest {

    @Test
    public void testEvaluate() {
        LowerThan matcher = new LowerThan(new BigDecimal("1"));
        assertTrue(matcher.evaluate("0"));
        assertFalse(matcher.evaluate("2"));
    }

}
