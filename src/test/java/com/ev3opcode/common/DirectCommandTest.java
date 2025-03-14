package com.ev3opcode.common;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.commands.file.LoadImage;
import com.ev3opcode.commands.file.arguments.returns.ImageAddressDataGlobalMemoryBlock;
import com.ev3opcode.commands.file.arguments.returns.ImageAddressDataMemoryBlock;
import com.ev3opcode.commands.file.arguments.returns.ImageSizeDataGlobalMemoryBlock;
import com.ev3opcode.commands.file.arguments.returns.ImageSizeDataMemoryBlock;
import com.ev3opcode.commands.program.ProgramStart;
import com.ev3opcode.commands.program.arguments.ProgramDebugMode;
import com.ev3opcode.commands.program.arguments.ProgramDebugModeValue;
import com.ev3opcode.commands.program.arguments.ProgramIdValue;
import com.ev3opcode.commands.program.arguments.ProgramImageAddress;
import com.ev3opcode.commands.program.arguments.ProgramImageAddressGlobalReference;
import com.ev3opcode.commands.program.arguments.ProgramImageSize;
import com.ev3opcode.commands.program.arguments.ProgramImageSizeGlobalReference;
import com.ev3opcode.commands.program.types.DebugMode;
import com.ev3opcode.commands.program.types.ProgramID;
import com.ev3opcode.common.arguments.FileNameValue;
import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class DirectCommandTest {
    private class GlobalMemoryHungryCommandMock extends Command {
        @Override
        public Byte getOpCode() {
            return null;
        }

        @Override
        public int allocatedGlobalBlockSize() {
            return 12345678;
        }

        @Override
        public int allocatedLocalBlockSize() {
            return 0;
        }

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public Byte[] getBytes() {
            return new Byte[0];
        }
    }

    private class LocalMemoryHungryCommandMock extends Command {
        @Override
        public Byte getOpCode() {
            return null;
        }

        @Override
        public int allocatedGlobalBlockSize() {
            return 0;
        }

        @Override
        public int allocatedLocalBlockSize() {
            return 12345678;
        }

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public Byte[] getBytes() {
            return new Byte[0];
        }
    }

    private DirectCommand m_command;
    private String m_commandsExpectedByteCodes = "2E000000800800C00801842E2E2F70726A732F42726B50726F675F534156452F44656D6F2E7270660060640301606400";

    private DirectCommand m_emptyCommand;
    private String m_emptyCommandExpectedByteCode = "05000000800000";

    @Before
    public void setUp() throws Exception {
        ProgramIdValue programId = new ProgramIdValue(ProgramID.USER_SLOT);
        FileNameValue programName = new FileNameValue("../prjs/BrkProg_SAVE/Demo.rpf");
        ImageSizeDataMemoryBlock sizeMemoryBlock = new ImageSizeDataGlobalMemoryBlock(0);
        ImageAddressDataMemoryBlock addressMemoryBlock = new ImageAddressDataGlobalMemoryBlock(4);

        LoadImage loadImageCommand = new LoadImage(programId, programName, sizeMemoryBlock, addressMemoryBlock);

        ProgramImageSize imageSize = new ProgramImageSizeGlobalReference((byte) 0);
        ProgramImageAddress imageAddress = new ProgramImageAddressGlobalReference((byte) 4);
        ProgramDebugMode debugMode = new ProgramDebugModeValue(DebugMode.NORMAL);

        ProgramStart programStartCommand = new ProgramStart(programId, imageSize, imageAddress, debugMode);

        m_command = new DirectCommand((short) 0, DirectCommandType.NO_REPLY_REQUIRED);
        m_command.addCommand(loadImageCommand);
        m_command.addCommand(programStartCommand);

        m_emptyCommand = new DirectCommand((short) 0, DirectCommandType.NO_REPLY_REQUIRED);
    }

    @Test
    public void getBytes_empty_7() {
        Byte[] bytes = m_emptyCommand.getBytes();
        assertEquals(7, bytes.length);
    }

    @Test
    public void getSize_empty_5() {
        assertEquals(5, m_emptyCommand.getSize());
    }

    @Test
    public void getBytes_empty_expectedByteCodes() {
        Byte[] byteCode = m_emptyCommand.getBytes();
        for (int i = 0, j = 0; i < m_emptyCommandExpectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_emptyCommandExpectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }

    @Test
    public void getBytes_commands_48() {
        Byte[] bytes = m_command.getBytes();
        assertEquals(48, bytes.length);
    }

    @Test
    public void getSize_commands_46() {
        assertEquals(46, m_command.getSize());
    }

    @Test
    public void getBytes_commands_expectedByteCodes() {
        Byte[] byteCode = m_command.getBytes();
        for (int i = 0, j = 0; i < m_commandsExpectedByteCodes.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_commandsExpectedByteCodes.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }

    @Test(expected = RuntimeException.class)
    public void addCommand_globalMemoryHungryCommand_throwsException() {
        m_emptyCommand.addCommand(new GlobalMemoryHungryCommandMock());
    }

    @Test(expected = RuntimeException.class)
    public void addCommand_localMemoryHungryCommand_throwsException() {
        m_emptyCommand.addCommand(new LocalMemoryHungryCommandMock());
    }

    @Test
    public void getMessageNumber_5_5() {
        DirectCommand test = new DirectCommand((short) 5, DirectCommandType.REPLY_REQUIRED);
        assertEquals(5, test.getMessageNumber());
    }

    @Test
    public void getBytes_5_byteCodes() {
        DirectCommand test = new DirectCommand((short) 5, DirectCommandType.REPLY_REQUIRED);
        String expected = "05000500000000";

        Byte[] byteCode = test.getBytes();

        for (int i = 0, j = 0; i < expected.length() - 2; i += 2, ++j) {
            String expectedByteCode = expected.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }
}