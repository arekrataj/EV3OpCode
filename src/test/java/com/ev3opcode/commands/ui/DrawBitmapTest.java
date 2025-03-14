package com.ev3opcode.commands.ui;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.ui.arguments.Color;
import com.ev3opcode.commands.ui.arguments.ColorValue;
import com.ev3opcode.commands.ui.arguments.XStart;
import com.ev3opcode.commands.ui.arguments.XStartValue;
import com.ev3opcode.commands.ui.arguments.YStart;
import com.ev3opcode.commands.ui.arguments.YStartValue;
import com.ev3opcode.common.arguments.FileName;
import com.ev3opcode.common.arguments.FileNameValue;

import static org.junit.Assert.assertEquals;

public class DrawBitmapTest {
    DrawBitmap m_command;
    String m_expectedByteCode = "841C018132008475692F6D696E6473746F726D732E72676600";

    @Before
    public void setUp() throws Exception {
        Color color = new ColorValue(com.ev3opcode.commands.ui.types.Color.BLACK);
        XStart xStart = new XStartValue(50);
        YStart yStart = new YStartValue(0);
        FileName fileName = new FileNameValue("ui/mindstorms.rgf");

        m_command = new DrawBitmap(color, xStart, yStart, fileName);
    }

    @Test(expected = RuntimeException.class)
    public void xStartValue_negative_throwsException() {
        new XStartValue(-9);
    }

    @Test(expected = RuntimeException.class)
    public void xStartValue_positive200_throwsException() {
        new XStartValue(200);
    }

    @Test
    public void allocatedGlobalBlockSize_DrawBitmap_0() {
        assertEquals(0, m_command.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_DrawBitmap_0() {
        assertEquals(0, m_command.allocatedLocalBlockSize());
    }

    @Test
    public void getBytes_DrawBitmap_lengthOf25() {
        assertEquals(25, m_command.getBytes().length);
    }

    @Test
    public void getSize_DrawBitmap_25() {
        assertEquals(25, m_command.getSize());
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