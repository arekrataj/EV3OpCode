package com.ev3opcode.commands.output.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TachoPulsesValueTest {
    private TachoPulsesValue m_tachoPulses;

    @Before
    public void setUp() throws Exception {
        m_tachoPulses = new TachoPulsesValue(666);
    }

    @Test
    public void getTachoPulses_returns666() {
        assertEquals(666, m_tachoPulses.getTachoPulses());
    }

    @Test
    public void setTachoPulses_777_setsValue() {
        m_tachoPulses.setTachoPulses(777);
        assertEquals(777, m_tachoPulses.getTachoPulses());
    }
}