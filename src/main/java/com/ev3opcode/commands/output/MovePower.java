package com.ev3opcode.commands.output;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.output.arguments.MotorBitField;
import com.ev3opcode.commands.output.arguments.PowerLevel;
import com.ev3opcode.common.Command;
import com.ev3opcode.common.arguments.ChainLayerNumber;

public final class MovePower extends Command {
    private static byte OPCODE = (byte) 0xA4;

    private ChainLayerNumber m_chainLayerNumber;
    private MotorBitField m_motorBitField;
    private PowerLevel m_powerLevel;

    public MovePower(
            ChainLayerNumber chainLayerNumber,
            MotorBitField motorBitField,
            PowerLevel powerLevel) {
        m_chainLayerNumber = chainLayerNumber;
        m_motorBitField = motorBitField;
        m_powerLevel = powerLevel;
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
        int powerLevelSize = m_powerLevel.getSize();

        return opCodeSize +
                chainLayerNumberSize +
                motorBitFieldSize +
                powerLevelSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_chainLayerNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_motorBitField.getBytes()));
        outputBytes.addAll(Arrays.asList(m_powerLevel.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
