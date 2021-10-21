package com.harium.suneidesis.concept.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTest {

    @Test
    public void testToISO() {
        assertEquals("2020-02-01T09:08:07.000Z", new Date(2020, 2,1, 9,8,7).toISO());
        // There is no validation
        assertEquals("2021-22-01T09:08:07.000Z", new Date(2021, 22,1, 9,8,7).toISO());
        assertEquals("2022-02-41T09:08:07.000Z", new Date(2022, 2,41, 9,8,7).toISO());
    }

}
