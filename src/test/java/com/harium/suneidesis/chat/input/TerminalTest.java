package com.harium.suneidesis.chat.input;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TerminalTest {

    private Terminal terminal;

    @Before
    public void setUp() {
        terminal = new Terminal();
    }

    @Test
    public void testEnhance() {
        InputContext context = new InputContext();
        terminal.enhanceInputContext(context);

        Map<String, Object> properties = context.getProperties();
        assertEquals("", properties.get(InputContext.USER_ID));
        assertEquals("", properties.get(InputContext.USER_NAME));
        assertEquals(terminal.getUsername(), properties.get(InputContext.USER_USERNAME));
        assertEquals("", properties.get(InputContext.CHANNEL_ID));
        assertEquals("", properties.get(InputContext.CHANNEL_NAME));
        assertEquals(terminal.getLanguage(), properties.get(InputContext.LANGUAGE));
    }

}
