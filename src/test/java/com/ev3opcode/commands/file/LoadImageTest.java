package com.ev3opcode.commands.file;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.ArraysHelper;
import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.file.arguments.returns.ImageAddressDataGlobalMemoryBlock;
import com.ev3opcode.commands.file.arguments.returns.ImageAddressDataMemoryBlock;
import com.ev3opcode.commands.file.arguments.returns.ImageSizeDataGlobalMemoryBlock;
import com.ev3opcode.commands.file.arguments.returns.ImageSizeDataMemoryBlock;
import com.ev3opcode.commands.program.arguments.ProgramIdValue;
import com.ev3opcode.commands.program.types.ProgramID;
import com.ev3opcode.common.ResponseBuffer;
import com.ev3opcode.common.arguments.FileNameValue;
import com.ev3opcode.common.tools.BinaryConverter;

import static org.junit.Assert.assertEquals;

public class LoadImageTest {
    private LoadImage m_loadImageCommand;
    private String m_expectedByteCode = "C00801842E2E2F70726A732F42726B50726F675F534156452F44656D6F2E727066006064";

    @Before
    public void setUp() throws Exception {
        ProgramIdValue programId = new ProgramIdValue(ProgramID.USER_SLOT);
        FileNameValue programName = new FileNameValue("../prjs/BrkProg_SAVE/Demo.rpf");
        ImageSizeDataMemoryBlock sizeMemoryBlock = new ImageSizeDataGlobalMemoryBlock(0);
        ImageAddressDataMemoryBlock addressMemoryBlock = new ImageAddressDataGlobalMemoryBlock(4);
        m_loadImageCommand = new LoadImage(programId, programName, sizeMemoryBlock, addressMemoryBlock);
    }

    @Test
    public void allocatedGlobalBlockSize_LoadImage_8() {
        assertEquals(8, m_loadImageCommand.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_LoadImage_0() {
        assertEquals(0, m_loadImageCommand.allocatedLocalBlockSize());
    }

    @Test
    public void getSize_LoadImage_36() {
        assertEquals(36, m_loadImageCommand.getSize());
    }

    @Test
    public void getBytes_LoadImage_lengthOf36() {
        assertEquals(36, m_loadImageCommand.getBytes().length);
    }

    @Test
    public void getBytes_LoadImage_expectedByteCode() {
        Byte[] byteCode = m_loadImageCommand.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }

    @Test
    public void LoadImageReturnedValues_responseBuffer_properValues() {
        Byte[] first = BinaryConverter.intToFourBytesLE(123456789);
        Byte[] second = BinaryConverter.intToFourBytesLE(987654321);
        Byte[] buffer = ArraysHelper.concatenate(first, second);
        ResponseBuffer responseBuffer = new ResponseBuffer(buffer);

        LoadImage.ReturnedValues returnedValues = m_loadImageCommand.getReturnedValues(responseBuffer);

        assertEquals(123456789, returnedValues.getImageSize());
        assertEquals(987654321, returnedValues.getImageAddress());
    }
}