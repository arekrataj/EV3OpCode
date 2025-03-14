package com.ev3opcode.commands.output;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.output.arguments.MotorBitField;
import com.ev3opcode.commands.output.arguments.SpeedLevel;
import com.ev3opcode.common.Command;
import com.ev3opcode.common.arguments.ChainLayerNumber;

public final class MoveSpeed extends Command {
    private static byte OPCODE = (byte) 0xA5;

    private ChainLayerNumber m_chainLayerNumber;
    private MotorBitField m_motorBitField;
    private SpeedLevel m_speedLevel;

    public MoveSpeed(
            ChainLayerNumber chainLayerNumber,
            MotorBitField motorBitField,
            SpeedLevel speedLevel) {
        m_chainLayerNumber = chainLayerNumber;
        m_motorBitField = motorBitField;
        m_speedLevel = speedLevel;
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

        return opCodeSize +
                chainLayerNumberSize +
                motorBitFieldSize +
                speedLevelSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_chainLayerNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_motorBitField.getBytes()));
        outputBytes.addAll(Arrays.asList(m_speedLevel.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
