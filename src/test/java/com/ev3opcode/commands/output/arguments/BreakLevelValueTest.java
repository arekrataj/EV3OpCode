package com.ev3opcode.commands.output.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.commands.output.types.BreakLevel;

import static org.junit.Assert.assertEquals;

public class BreakLevelValueTest {
    private BreakLevelValue m_breakLevel;

    @Before
    public void setUp() throws Exception {
        m_breakLevel = new BreakLevelValue(BreakLevel.BREAK);
    }

    @Test
    public void getBreakLevel_returnsBreak() {
        assertEquals(BreakLevel.BREAK, m_breakLevel.getBreakLevel());
    }

    @Test
    public void setBreakLevel_float_setsValue() {
        m_breakLevel.setBreakLevel(BreakLevel.FLOAT);
        assertEquals(BreakLevel.FLOAT, m_breakLevel.getBreakLevel());
    }
}