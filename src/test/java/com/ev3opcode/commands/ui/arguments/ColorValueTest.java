package com.ev3opcode.commands.ui.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.commands.ui.types.Color;

import static org.junit.Assert.assertEquals;

public class ColorValueTest {
    private ColorValue m_colorValue;

    @Before
    public void setUp() throws Exception {
        m_colorValue = new ColorValue(Color.BLACK);
    }

    @Test
    public void getColor_returnsBlack() {
        assertEquals(Color.BLACK, m_colorValue.getColor());
    }

    @Test
    public void setColor_white_setsValue() {
        m_colorValue.setColor(Color.WHITE);
        assertEquals(Color.WHITE, m_colorValue.getColor());
    }
}