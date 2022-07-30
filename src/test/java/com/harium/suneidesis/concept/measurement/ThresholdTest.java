package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.helper.matchers.LowerThan;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;

public class ThresholdTest {

    @Test
    public void testMatcher() {
        Threshold hemoglobin = new Threshold();
        hemoglobin.unit("gram/100 ml");
        hemoglobin.min("0");
        hemoglobin.threshold("15");
        hemoglobin.value("15");

        LowerThan matcher = new LowerThan(new BigDecimal(hemoglobin.getThreshold()));
        assertFalse(hemoglobin.matches(matcher));
    }

}
