package com.ev3opcode.commands.input;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.input.arguments.DeviceMode;
import com.ev3opcode.commands.input.arguments.DeviceModeValue;
import com.ev3opcode.commands.input.arguments.DeviceType;
import com.ev3opcode.commands.input.arguments.DeviceTypeValue;
import com.ev3opcode.commands.input.arguments.returns.SensorSIDataGlobalMemoryBlock;
import com.ev3opcode.commands.input.arguments.returns.SensorSIDataLocalMemoryBlock;
import com.ev3opcode.commands.input.arguments.returns.SensorSIDataMemoryBlock;
import com.ev3opcode.common.arguments.ChainLayerNumber;
import com.ev3opcode.common.arguments.ChainLayerNumberValue;
import com.ev3opcode.common.arguments.NumberOfReturnValues;
import com.ev3opcode.common.arguments.NumberOfReturnValuesGlobalReference;
import com.ev3opcode.common.arguments.NumberOfReturnValuesLocalReference;
import com.ev3opcode.common.arguments.NumberOfReturnValuesValue;
import com.ev3opcode.common.arguments.PortNumber;
import com.ev3opcode.common.arguments.PortNumberValue;

import static org.junit.Assert.assertEquals;

public class ReadySITest {
    ReadySI m_readySICommand1;
    String m_expectedByteCode1 = "991D000200000160";

    ReadySI m_readySICommand2;
    String m_expectedByteCode2 = "991D00020000C1465F";

    ReadySI m_readySICommand3;
    String m_expectedByteCode3 = "991D000000020160";

    @Before
    public void setUp() throws Exception {
        ChainLayerNumber chainLayerNumber1 = new ChainLayerNumberValue(
                com.ev3opcode.common.types.ChainLayerNumber.ZERO);
        PortNumber portNumber1 = new PortNumberValue(com.ev3opcode.common.types.PortNumber.THREE);
        DeviceType deviceType1 = new DeviceTypeValue(0);
        DeviceMode deviceMode1 = new DeviceModeValue(com.ev3opcode.commands.input.types.DeviceMode.ZERO);
        NumberOfReturnValues numOfValues1 = new NumberOfReturnValuesValue(1);
        SensorSIDataMemoryBlock dataMemoryBlock1 = new SensorSIDataGlobalMemoryBlock(0);

        m_readySICommand1 = new ReadySI(chainLayerNumber1, portNumber1, deviceType1, deviceMode1, numOfValues1,
                dataMemoryBlock1);

        ChainLayerNumber chainLayerNumber2 = new ChainLayerNumberValue(
                com.ev3opcode.common.types.ChainLayerNumber.ZERO);
        PortNumber portNumber2 = new PortNumberValue(com.ev3opcode.common.types.PortNumber.THREE);
        DeviceType deviceType2 = new DeviceTypeValue(0);
        DeviceMode deviceMode2 = new DeviceModeValue(com.ev3opcode.commands.input.types.DeviceMode.ZERO);
        NumberOfReturnValues numOfValues2 = new NumberOfReturnValuesLocalReference(70);
        SensorSIDataMemoryBlock dataMemoryBlock2 = new SensorSIDataLocalMemoryBlock(31);

        m_readySICommand2 = new ReadySI(chainLayerNumber2, portNumber2, deviceType2, deviceMode2, numOfValues2,
                (byte) 4, dataMemoryBlock2);

        ChainLayerNumber chainLayerNumber3 = new ChainLayerNumberValue(
                com.ev3opcode.common.types.ChainLayerNumber.ZERO);
        PortNumber portNumber3 = new PortNumberValue(com.ev3opcode.common.types.PortNumber.ONE);
        DeviceType deviceType3 = new DeviceTypeValue(0);
        DeviceMode deviceMode3 = new DeviceModeValue(com.ev3opcode.commands.input.types.DeviceMode.TWO);
        NumberOfReturnValues numOfValues3 = new NumberOfReturnValuesValue(1);
        SensorSIDataMemoryBlock dataMemoryBlock3 = new SensorSIDataGlobalMemoryBlock(0);

        m_readySICommand3 = new ReadySI(chainLayerNumber3, portNumber3, deviceType3, deviceMode3, numOfValues3,
                dataMemoryBlock3);
    }

    @Test(expected = RuntimeException.class)
    public void ctor_referenceToNumberOfValuesAndNoAllocationInformation_throwsException() {
        ChainLayerNumber chainLayerNumber = new ChainLayerNumberValue(com.ev3opcode.common.types.ChainLayerNumber.ZERO);
        PortNumber portNumber = new PortNumberValue(com.ev3opcode.common.types.PortNumber.ONE);
        DeviceType deviceType = new DeviceTypeValue(0);
        DeviceMode deviceMode = new DeviceModeValue(com.ev3opcode.commands.input.types.DeviceMode.ZERO);
        NumberOfReturnValues numOfValues = new NumberOfReturnValuesGlobalReference(1);
        SensorSIDataMemoryBlock dataMemoryBlock = new SensorSIDataGlobalMemoryBlock(0);

        new ReadySI(chainLayerNumber, portNumber, deviceType, deviceMode, numOfValues, dataMemoryBlock);
    }

    @Test
    public void getBytes_ReadySI1_lengthOf8() {
        assertEquals(8, m_readySICommand1.getBytes().length);
    }

    @Test
    public void getSize_ReadySI1_8() {
        assertEquals(8, m_readySICommand1.getSize());
    }

    @Test
    public void getBytes_ReadySI1_expectedByteCode() {
        Byte[] byteCode = m_readySICommand1.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode1.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode1.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }

    @Test
    public void allocatedGlobalBlockSize_ReadySI1_4() {
        assertEquals(4, m_readySICommand1.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_ReadySI1_0() {
        assertEquals(0, m_readySICommand1.allocatedLocalBlockSize());
    }

    @Test
    public void getBytes_ReadySI2_lengthOf9() {
        assertEquals(9, m_readySICommand2.getBytes().length);
    }

    @Test
    public void getSize_ReadySI2_9() {
        assertEquals(9, m_readySICommand2.getSize());
    }

    @Test
    public void getBytes_ReadySI2_expectedByteCode() {
        Byte[] byteCode = m_readySICommand2.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode2.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode2.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }

    @Test
    public void allocatedGlobalBlockSize_ReadySI2_0() {
        assertEquals(0, m_readySICommand2.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_ReadySI2_16() {
        assertEquals(16, m_readySICommand2.allocatedLocalBlockSize());
    }

    @Test
    public void getBytes_ReadySI3_expectedByteCode() {
        Byte[] byteCode = m_readySICommand3.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode3.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode3.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }

    @Test
    public void getBytes_ReadySI3_lengthOf8() {
        assertEquals(8, m_readySICommand3.getBytes().length);
    }

    @Test
    public void getSize_ReadySI3_8() {
        assertEquals(8, m_readySICommand3.getSize());
    }
}