package com.ev3opcode.commands.program;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.program.arguments.ProgramDebugMode;
import com.ev3opcode.commands.program.arguments.ProgramDebugModeValue;
import com.ev3opcode.commands.program.arguments.ProgramIdValue;
import com.ev3opcode.commands.program.arguments.ProgramImageAddress;
import com.ev3opcode.commands.program.arguments.ProgramImageAddressGlobalReference;
import com.ev3opcode.commands.program.arguments.ProgramImageSize;
import com.ev3opcode.commands.program.arguments.ProgramImageSizeGlobalReference;
import com.ev3opcode.commands.program.types.DebugMode;
import com.ev3opcode.commands.program.types.ProgramID;

import static org.junit.Assert.assertEquals;

public class ProgramStartTest {
    private ProgramStart m_programStartCommand;
    private String m_expectedByteCode = "0301606400";

    @Before
    public void setUp() throws Exception {
        ProgramIdValue programId = new ProgramIdValue(ProgramID.USER_SLOT);
        ProgramImageSize imageSize = new ProgramImageSizeGlobalReference((byte) 0);
        ProgramImageAddress imageAddress = new ProgramImageAddressGlobalReference((byte) 4);
        ProgramDebugMode debugMode = new ProgramDebugModeValue(DebugMode.NORMAL);

        m_programStartCommand = new ProgramStart(programId, imageSize, imageAddress, debugMode);
    }

    @Test
    public void allocatedGlobalBlockSize_ProgramStart_0() {
        assertEquals(0, m_programStartCommand.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_ProgramStart_0() {
        assertEquals(0, m_programStartCommand.allocatedLocalBlockSize());
    }

    @Test
    public void getSize_ProgramStart_5() {
        assertEquals(5, m_programStartCommand.getSize());
    }

    @Test
    public void getBytes_ProgramStart_lengthOf5() {
        assertEquals(5, m_programStartCommand.getBytes().length);
    }

    @Test
    public void getBytes_ProgramStart_expectedByteCode() {
        Byte[] byteCode = m_programStartCommand.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }
}