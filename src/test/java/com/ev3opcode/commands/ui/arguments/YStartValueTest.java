package com.ev3opcode.commands.ui.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YStartValueTest {
    private YStartValue m_yStartValue;

    @Before
    public void setUp() throws Exception {
        m_yStartValue = new YStartValue(123);
    }

    @Test
    public void getYStart_return123() {
        assertEquals(123, m_yStartValue.getYStart());
    }

    @Test
    public void setYStart_13_setsValue() {
        m_yStartValue.setYStart(13);
        assertEquals(13, m_yStartValue.getYStart());
    }

    @Test(expected = RuntimeException.class)
    public void setYStart_lessThanZero_throwsException() {
        m_yStartValue.setYStart(-13);
    }

    @Test(expected = RuntimeException.class)
    public void setYStart_greaterThan127_throwsException() {
        m_yStartValue.setYStart(128);
    }
}