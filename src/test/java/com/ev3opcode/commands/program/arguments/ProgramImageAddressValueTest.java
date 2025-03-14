package com.ev3opcode.commands.program.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramImageAddressValueTest {
    private ProgramImageAddressValue m_imageAddress;

    @Before
    public void setUp() throws Exception {
        m_imageAddress = new ProgramImageAddressValue(256);
    }

    @Test
    public void getImageAddress_returns256() {
        assertEquals(256, m_imageAddress.getImageAddress());
    }

    @Test
    public void setImageAddress_128_setsValue() {
        m_imageAddress.setImageAddress(128);
        assertEquals(128, m_imageAddress.getImageAddress());
    }
}