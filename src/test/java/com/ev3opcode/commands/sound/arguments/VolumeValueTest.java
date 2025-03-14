package com.ev3opcode.commands.sound.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VolumeValueTest {
    private VolumeValue m_volumeValue;

    @Before
    public void setUp() throws Exception {
        m_volumeValue = new VolumeValue(56);
    }

    @Test
    public void getVolume_returns56() {
        assertEquals(56, m_volumeValue.getVolume());
    }

    @Test
    public void setVolume_10_setsValue() {
        m_volumeValue.setVolume(10);
        assertEquals(10, m_volumeValue.getVolume());
    }

    @Test(expected = RuntimeException.class)
    public void setVolume_lessThanZero_throwsException() {
        m_volumeValue.setVolume(-9);
    }

    @Test(expected = RuntimeException.class)
    public void setVolume_greaterThan100_throwsException() {
        m_volumeValue.setVolume(101);
    }
}