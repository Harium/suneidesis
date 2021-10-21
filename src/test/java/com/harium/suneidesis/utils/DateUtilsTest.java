package com.harium.suneidesis.utils;

import com.harium.suneidesis.concept.time.Date;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilsTest {

    @Test
    public void testCheckCronExpression() {
        Date date = new Date(2020, 1, 2, 0, 0, 0);
        assertTrue(DateUtils.checkCronExpression("* * * * * *", date));
        assertTrue(DateUtils.checkCronExpression("0 0 0 ? * *", date));
        assertFalse(DateUtils.checkCronExpression("1 0 0 ? * *", date));
    }

}
