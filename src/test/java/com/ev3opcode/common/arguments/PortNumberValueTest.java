package com.ev3opcode.common.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.common.types.PortNumber;

import static org.junit.Assert.assertEquals;

public class PortNumberValueTest {
    private PortNumberValue m_portNumber;

    @Before
    public void setUp() throws Exception {
        m_portNumber = new PortNumberValue(PortNumber.THREE);
    }

    @Test
    public void getPortNumber_returnsThree() {
        assertEquals(PortNumber.THREE, m_portNumber.getPortNumber());
    }

    @Test
    public void setPortNumber_twp_setsValue() {
        m_portNumber.setPortNumber(PortNumber.TWO);
        assertEquals(PortNumber.TWO, m_portNumber.getPortNumber());
    }
}