package com.ev3opcode.common.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.common.types.ChainLayerNumber;

import static org.junit.Assert.assertEquals;

public class ChainLayerNumberValueTest {
    private ChainLayerNumberValue m_chainLayerNumber;

    @Before
    public void setUp() throws Exception {
        m_chainLayerNumber = new ChainLayerNumberValue(ChainLayerNumber.ZERO);
    }

    @Test
    public void getLayerNumber_returnsZero() {
        assertEquals(ChainLayerNumber.ZERO, m_chainLayerNumber.getLayerNumber());
    }

    @Test
    public void setLayerNumber_three_setsValue() {
        m_chainLayerNumber.setLayerNumber(ChainLayerNumber.THREE);
        assertEquals(ChainLayerNumber.THREE, m_chainLayerNumber.getLayerNumber());
    }
}