package com.ev3opcode.commands.output;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.output.arguments.MotorBitField;
import com.ev3opcode.commands.output.arguments.MotorBitFieldValue;
import com.ev3opcode.commands.output.arguments.SpeedLevel;
import com.ev3opcode.commands.output.arguments.SpeedLevelValue;
import com.ev3opcode.common.arguments.ChainLayerNumber;
import com.ev3opcode.common.arguments.ChainLayerNumberValue;

import static org.junit.Assert.assertEquals;

public class MoveSpeedTest {
    private MoveSpeed m_moveSpeedCommand;
    private String m_expectedByteCode = "A500068132";

    @Before
    public void setUp() throws Exception {
        ChainLayerNumber chainLevelNumber = new ChainLayerNumberValue(com.ev3opcode.common.types.ChainLayerNumber.ZERO);
        MotorBitField motorBitField = new MotorBitFieldValue(false, true, true, false);
        SpeedLevel speedLevel = new SpeedLevelValue((byte) 50);

        m_moveSpeedCommand = new MoveSpeed(chainLevelNumber, motorBitField, speedLevel);
    }

    @Test(expected = RuntimeException.class)
    public void SpeedLevelValue_negative101_throwsException() {
        new SpeedLevelValue(-101);
    }

    @Test(expected = RuntimeException.class)
    public void SpeedLevelValue_positive101_throwsException() {
        new SpeedLevelValue(101);
    }

    @Test
    public void allocatedGlobalBlockSize_MoveSpeed_0() {
        assertEquals(0, m_moveSpeedCommand.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_MoveSpeed_0() {
        assertEquals(0, m_moveSpeedCommand.allocatedLocalBlockSize());
    }

    @Test
    public void getSize_MoveSpeed_5() {
        assertEquals(5, m_moveSpeedCommand.getSize());
    }

    @Test
    public void getBytes_MoveSpeed_lengthOf5() {
        assertEquals(5, m_moveSpeedCommand.getBytes().length);
    }

    @Test
    public void getBytes_MoveStepSpeed_expectedByteCode() {
        Byte[] byteCode = m_moveSpeedCommand.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }
}