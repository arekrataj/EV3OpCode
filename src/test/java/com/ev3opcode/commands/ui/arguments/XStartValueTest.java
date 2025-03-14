package com.ev3opcode.commands.ui.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XStartValueTest {
    private XStartValue m_xStartValue;

    @Before
    public void setUp() throws Exception {
        m_xStartValue = new XStartValue(20);
    }

    @Test
    public void getXStart_returns20() {
        assertEquals(20, m_xStartValue.getXStart());
    }

    @Test
    public void setXStart_32_setsValue() {
        m_xStartValue.setXStart(32);
        assertEquals(32, m_xStartValue.getXStart());
    }

    @Test(expected = RuntimeException.class)
    public void setXStart_lessThanZero_throwsException() {
        m_xStartValue.setXStart(-1);
    }

    @Test(expected = RuntimeException.class)
    public void setXStart_greaterThan177_throwsException() {
        m_xStartValue.setXStart(200);
    }
}