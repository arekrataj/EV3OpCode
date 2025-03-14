package com.ev3opcode.commands.sound.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrequencyValueTest {
    private FrequencyValue m_frequency;

    @Before
    public void setUp() throws Exception {
        m_frequency = new FrequencyValue(1984);
    }

    @Test
    public void getFrequency_returns1984() {
        assertEquals(1984, m_frequency.getFrequency());
    }

    @Test
    public void setFrequency_5000_setsValue() {
        m_frequency.setFrequency(5000);
        assertEquals(5000, m_frequency.getFrequency());
    }

    @Test(expected = RuntimeException.class)
    public void setFrequency_lessThan250_throwsException() {
        m_frequency.setFrequency(100);
    }

    @Test(expected = RuntimeException.class)
    public void setFrequency_greaterThan10000_throwsException() {
        m_frequency.setFrequency(20000);
    }
}