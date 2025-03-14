package com.ev3opcode.commands.output;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.output.arguments.MotorBitField;
import com.ev3opcode.commands.output.arguments.SpeedLevel;
import com.ev3opcode.commands.output.arguments.TimeInMillis;
import com.ev3opcode.common.Command;
import com.ev3opcode.common.arguments.ChainLayerNumber;

public final class MoveTimeSpeed extends Command {
    private static byte OPCODE = (byte) 0xAF;

    private ChainLayerNumber m_chainLayerNumber;
    private MotorBitField m_motorBitField;
    private SpeedLevel m_speedLevel;
    private TimeInMillis m_timeRampUp;
    private TimeInMillis m_timeContinue;
    private TimeInMillis m_timeRampDown;
    private com.ev3opcode.commands.output.arguments.BreakLevel m_breakLevel;

    public MoveTimeSpeed(
            ChainLayerNumber chainLayerNumber,
            MotorBitField motorBitField,
            SpeedLevel speedLevel,
            TimeInMillis timeRampUp,
            TimeInMillis timeContinue,
            TimeInMillis timeRampDown,
            com.ev3opcode.commands.output.arguments.BreakLevel breakLevel) {
        m_chainLayerNumber = chainLayerNumber;
        m_motorBitField = motorBitField;
        m_speedLevel = speedLevel;
        m_timeRampUp = timeRampUp;
        m_timeContinue = timeContinue;
        m_timeRampDown = timeRampDown;
        m_breakLevel = breakLevel;
    }

    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Contract(pure = true)
    @Override
    public int allocatedGlobalBlockSize() {
        return 0;
    }

    @Contract(pure = true)
    @Override
    public int allocatedLocalBlockSize() {
        return 0;
    }

    @Override
    public int getSize() {
        int opCodeSize = 1; // plus 1 for this command opcode
        int chainLayerNumberSize = m_chainLayerNumber.getSize();
        int motorBitFieldSize = m_motorBitField.getSize();
        int speedLevelSize = m_speedLevel.getSize();
        int timeRampUpSize = m_timeRampUp.getSize();
        int timeContinueSize = m_timeContinue.getSize();
        int timeRampDownSize = m_timeRampDown.getSize();
        int breakLevelSize = m_breakLevel.getSize();

        return opCodeSize +
                chainLayerNumberSize +
                motorBitFieldSize +
                speedLevelSize +
                timeRampUpSize +
                timeContinueSize +
                timeRampDownSize +
                breakLevelSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_chainLayerNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_motorBitField.getBytes()));
        outputBytes.addAll(Arrays.asList(m_speedLevel.getBytes()));
        outputBytes.addAll(Arrays.asList(m_timeRampUp.getBytes()));
        outputBytes.addAll(Arrays.asList(m_timeContinue.getBytes()));
        outputBytes.addAll(Arrays.asList(m_timeRampDown.getBytes()));
        outputBytes.addAll(Arrays.asList(m_breakLevel.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
