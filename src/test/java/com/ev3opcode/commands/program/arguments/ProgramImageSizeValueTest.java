package com.ev3opcode.commands.program.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramImageSizeValueTest {
    private ProgramImageSizeValue m_imageSize;

    @Before
    public void setUp() throws Exception {
        m_imageSize = new ProgramImageSizeValue(100);
    }

    @Test
    public void getImageSize_returns100() {
        assertEquals(100, m_imageSize.getImageSize());
    }

    @Test
    public void setImageSize_256_setsValue() {
        m_imageSize.setImageSize(256);
        assertEquals(256, m_imageSize.getImageSize());
    }
}