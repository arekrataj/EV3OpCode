package com.ev3opcode.commands.sound.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DurationValueTest {
    private DurationValue m_duration;

    @Before
    public void setUp() throws Exception {
        m_duration = new DurationValue(256);
    }

    @Test
    public void getDuration_returns256() {
        assertEquals(256, m_duration.getDuration());
    }

    @Test
    public void setDuration_1000_setsValue() {
        m_duration.setDuration(1000);
        assertEquals(1000, m_duration.getDuration());
    }

    @Test(expected = RuntimeException.class)
    public void setDuration_greaterThan16bit_throwsException() {
        m_duration.setDuration(70000);
    }
}