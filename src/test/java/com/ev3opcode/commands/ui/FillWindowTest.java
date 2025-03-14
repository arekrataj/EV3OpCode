package com.ev3opcode.commands.ui;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.ui.arguments.Color;
import com.ev3opcode.commands.ui.arguments.ColorValue;
import com.ev3opcode.commands.ui.arguments.YSize;
import com.ev3opcode.commands.ui.arguments.YSizeValue;
import com.ev3opcode.commands.ui.arguments.YStart;
import com.ev3opcode.commands.ui.arguments.YStartValue;

import static org.junit.Assert.assertEquals;

public class FillWindowTest {
    FillWindow m_command;
    String m_expectedByteCode = "8413000000";

    @Before
    public void setUp() throws Exception {
        Color color = new ColorValue(com.ev3opcode.commands.ui.types.Color.WHITE);
        YStart yStart = new YStartValue(0);
        YSize ySize = new YSizeValue(0); // zero means all the screen

        m_command = new FillWindow(color, yStart, ySize);
    }

    @Test(expected = RuntimeException.class)
    public void ySizeValue_negative_throwsException() {
        new YStartValue(-1);
    }

    @Test(expected = RuntimeException.class)
    public void ySizeValue_128_throwsException() {
        new YStartValue(128);
    }

    @Test(expected = RuntimeException.class)
    public void yStartValue_32bit_throwsException() {
        new YStartValue(0xFFFFFF);
    }

    @Test
    public void allocatedGlobalBlockSize_FillWindow_0() {
        assertEquals(0, m_command.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_FillWindow_0() {
        assertEquals(0, m_command.allocatedLocalBlockSize());
    }

    @Test
    public void getBytes_FillWindow_lengthOf5() {
        assertEquals(5, m_command.getBytes().length);
    }

    @Test
    public void getSize_FillWindow_5() {
        assertEquals(5, m_command.getSize());
    }

    @Test
    public void getBytes_FillWindow_expectedByteCode() {
        Byte[] byteCode = m_command.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }
}