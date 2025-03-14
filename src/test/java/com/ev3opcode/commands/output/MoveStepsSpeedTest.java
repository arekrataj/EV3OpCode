package com.ev3opcode.commands.output;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;
import com.ev3opcode.commands.output.arguments.BreakLevelValue;
import com.ev3opcode.commands.output.arguments.MotorBitField;
import com.ev3opcode.commands.output.arguments.MotorBitFieldValue;
import com.ev3opcode.commands.output.arguments.SpeedLevel;
import com.ev3opcode.commands.output.arguments.PowerLevelValue;
import com.ev3opcode.commands.output.arguments.SpeedLevelValue;
import com.ev3opcode.commands.output.arguments.TachoPulses;
import com.ev3opcode.commands.output.arguments.TachoPulsesValue;
import com.ev3opcode.commands.output.types.BreakLevel;
import com.ev3opcode.common.arguments.ChainLayerNumber;
import com.ev3opcode.common.arguments.ChainLayerNumberValue;

import static org.junit.Assert.assertEquals;

public class MoveStepsSpeedTest {
    private MoveStepsSpeed m_moveStepsSpeedCommand;
    private String m_expectedByteCode = "AE000681320082840382B40001";

    @Before
    public void setUp() throws Exception {
        ChainLayerNumber chainLevelNumber = new ChainLayerNumberValue(com.ev3opcode.common.types.ChainLayerNumber.ZERO);
        MotorBitField motorBitField = new MotorBitFieldValue(false, true, true, false);
        SpeedLevel speedLevel = new SpeedLevelValue((byte) 50);
        TachoPulses tachoPulsesRampUp = new TachoPulsesValue(0);
        TachoPulses tachoPulsesContinue = new TachoPulsesValue(900);
        TachoPulses tachoPulsesRampDown = new TachoPulsesValue(180);
        com.ev3opcode.commands.output.arguments.BreakLevel breakLevel = new BreakLevelValue(BreakLevel.BREAK);

        m_moveStepsSpeedCommand = new MoveStepsSpeed(
                chainLevelNumber,
                motorBitField,
                speedLevel,
                tachoPulsesRampUp,
                tachoPulsesContinue,
                tachoPulsesRampDown,
                breakLevel);
    }

    @Test(expected = RuntimeException.class)
    public void PowerLevel_negative101_throwsException() {
        new PowerLevelValue(-101);
    }

    @Test(expected = RuntimeException.class)
    public void PowerLevel_positive101_throwsException() {
        new PowerLevelValue(101);
    }

    @Test
    public void allocatedGlobalBlockSize_MoveStepSpeed_0() {
        assertEquals(0, m_moveStepsSpeedCommand.allocatedGlobalBlockSize());
    }

    @Test
    public void allocatedLocalBlockSize_MoveStepSpeed_0() {
        assertEquals(0, m_moveStepsSpeedCommand.allocatedLocalBlockSize());
    }

    @Test
    public void getSize_MoveStepSpeed_13() {
        assertEquals(13, m_moveStepsSpeedCommand.getSize());
    }

    @Test
    public void getBytes_MoveStepSpeed_lengthOf13() {
        assertEquals(13, m_moveStepsSpeedCommand.getBytes().length);
    }

    @Test
    public void getBytes_MoveStepSpeed_expectedByteCode() {
        Byte[] byteCode = m_moveStepsSpeedCommand.getBytes();
        for (int i = 0, j = 0; i < m_expectedByteCode.length() - 2; i += 2, ++j) {
            String expectedByteCode = m_expectedByteCode.substring(i, i + 2);
            assertEquals(expectedByteCode, BinaryFormatHelper.byteToHexString(byteCode[j]));
        }
    }
}