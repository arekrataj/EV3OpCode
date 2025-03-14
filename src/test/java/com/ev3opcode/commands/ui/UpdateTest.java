package com.ev3opcode.commands.ui;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class UpdateTest {
    Update m_command;
    String m_expectedByteCode = "8400";

    @Before
    public void setUp() throws Exception {
        m_command = new Update();
    }

    @Test
    public void allocatedGlobalBlockSize_Update_0() {
        assertEquals(0, m_command.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_Update_0() {
        assertEquals(0, m_command.allocatedLocalBlockSize());
    }

    @Test
    public void getBytes_Update_lengthOf2() {
        assertEquals(2, m_command.getBytes().length);
    }

    @Test
    public void getSize_Update_2() {
        assertEquals(2, m_command.getSize());
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