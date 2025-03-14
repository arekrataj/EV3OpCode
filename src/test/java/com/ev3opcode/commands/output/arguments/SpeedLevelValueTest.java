package com.ev3opcode.commands.output.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpeedLevelValueTest {
    private SpeedLevelValue m_speedValue;

    @Before
    public void setUp() throws Exception {
        m_speedValue = new SpeedLevelValue(56);
    }

    @Test
    public void getSpeedLevel_returns56() {
        assertEquals(56, m_speedValue.getSpeedLevel());
    }

    @Test
    public void setSpeedLevel_21_setsValue() {
        m_speedValue.setSpeedLevel(21);
        assertEquals(21, m_speedValue.getSpeedLevel());
    }

    @Test(expected = RuntimeException.class)
    public void setSpeedLevel_lesserThanMinus100_throwsException() {
        m_speedValue.setSpeedLevel(-200);
    }

    @Test(expected = RuntimeException.class)
    public void setSpeedLevel_greaterThan100_throwsException() {
        m_speedValue.setSpeedLevel(200);
    }
}