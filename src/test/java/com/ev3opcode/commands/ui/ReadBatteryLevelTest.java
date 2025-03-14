package com.ev3opcode.commands.ui;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.ui.arguments.returns.BatteryLevelLocalMemoryBlock;
import com.ev3opcode.commands.ui.arguments.returns.BatteryLevelMemoryBlock;
import com.ev3opcode.common.ResponseBuffer;

import static org.junit.Assert.assertEquals;

public class ReadBatteryLevelTest {
    private ReadBatteryLevel m_readBatteryLevelCommand;
    private String m_expectedByteCode = "8112C146";

    @Before
    public void setUp() throws Exception {
        BatteryLevelMemoryBlock memoryBlock = new BatteryLevelLocalMemoryBlock(70);
        m_readBatteryLevelCommand = new ReadBatteryLevel(memoryBlock);
    }

    @Test
    public void allocatedGlobalBlockSize_LoadImage_0() {
        assertEquals(0, m_readBatteryLevelCommand.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_LoadImage_1() {
        assertEquals(1, m_readBatteryLevelCommand.allocatedLocalBlockSize());
    }

    @Test
    public void getSize_ReadBatteryLevel_4() {
        assertEquals(4, m_readBatteryLevelCommand.getSize());
    }

    @Test
    public void getBytes_ReadBatteryLevel_lengthOf4() {
        assertEquals(4, m_readBatteryLevelCommand.getBytes().length);
    }

    @Test
    public void getBytes_ReadBatteryLevel_expectedByteCode() {
        Byte[] byteCode = m_readBatteryLevelCommand.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }

    @Test
    public void LoadImageReturnedValues_responseBuffer_properValues() {
        Byte[] buffer = new Byte[71];
        buffer[70] = (byte) 123;
        ResponseBuffer responseBuffer = new ResponseBuffer(buffer);

        ReadBatteryLevel.ReturnedValues returnedValues = m_readBatteryLevelCommand.getReturnedValues(responseBuffer);

        assertEquals(123, returnedValues.getBatteryLevel());
    }
}