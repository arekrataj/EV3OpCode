package com.ev3opcode.commands.ui.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YSizeValueTest {
    private YSizeValue m_ySizeValue;

    @Before
    public void setUp() throws Exception {
        m_ySizeValue = new YSizeValue(256);
    }

    @Test
    public void getYSize_returns256() {
        assertEquals(256, m_ySizeValue.getYSize());
    }

    @Test
    public void setYSize_128_setsValue() {
        m_ySizeValue.setYSize(128);
        assertEquals(128, m_ySizeValue.getYSize());
    }

    @Test(expected = RuntimeException.class)
    public void setYSize_beyond16bitValue_throwsException() {
        m_ySizeValue.setYSize(3456789);
    }
}