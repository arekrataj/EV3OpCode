package com.ev3opcode.commands.output.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerLevelValueTest {
    private PowerLevelValue m_powerLevel;

    @Before
    public void setUp() throws Exception {
        m_powerLevel = new PowerLevelValue(12);
    }

    @Test
    public void getPowerLevel_returns12() {
        assertEquals(12, m_powerLevel.getPowerLevel());
    }

    @Test
    public void setPowerLevel_99_setsValue() {
        m_powerLevel.setPowerLevel(99);
        assertEquals(99, m_powerLevel.getPowerLevel());
    }

    @Test(expected = RuntimeException.class)
    public void setPowerLevel_lesserThanMinus100_throwsException() {
        m_powerLevel.setPowerLevel(-200);
    }

    @Test(expected = RuntimeException.class)
    public void setPowerLevel_greaterThan100_throwsException() {
        m_powerLevel.setPowerLevel(234);
    }
}