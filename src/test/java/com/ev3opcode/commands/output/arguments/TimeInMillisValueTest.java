package com.ev3opcode.commands.output.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeInMillisValueTest {
    private TimeInMillisValue m_timeMillis;

    @Before
    public void setUp() throws Exception {
        m_timeMillis = new TimeInMillisValue(1000);
    }

    @Test
    public void getTimeInMillis_returns1000() {
        assertEquals(1000, m_timeMillis.getTimeInMillis());
    }

    @Test
    public void setTimeInMillis_123_setsValue() {
        m_timeMillis.setTimeInMillis(123);
        assertEquals(123, m_timeMillis.getTimeInMillis());
    }
}