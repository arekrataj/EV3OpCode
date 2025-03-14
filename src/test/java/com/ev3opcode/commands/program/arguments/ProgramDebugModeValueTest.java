package com.ev3opcode.commands.program.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.commands.program.types.DebugMode;

import static org.junit.Assert.assertEquals;

public class ProgramDebugModeValueTest {
    private ProgramDebugModeValue m_debugMode;

    @Before
    public void setUp() throws Exception {
        m_debugMode = new ProgramDebugModeValue(DebugMode.NORMAL);
    }

    @Test
    public void getDebugMode_returnsValue() {
        assertEquals(DebugMode.NORMAL, m_debugMode.getDebugMode());
    }

    @Test
    public void setDebugMode_debug_setsValue() {
        m_debugMode.setDebugMode(DebugMode.DEBUG);
        assertEquals(DebugMode.DEBUG, m_debugMode.getDebugMode());
    }
}