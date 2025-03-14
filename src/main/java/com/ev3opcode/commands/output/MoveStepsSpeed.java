package com.ev3opcode.commands.output;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.output.arguments.MotorBitField;
import com.ev3opcode.commands.output.arguments.SpeedLevel;
import com.ev3opcode.commands.output.arguments.TachoPulses;
import com.ev3opcode.common.Command;
import com.ev3opcode.common.arguments.ChainLayerNumber;

public final class MoveStepsSpeed extends Command {
    private static byte OPCODE = (byte) 0xAE;

    private ChainLayerNumber m_chainLayerNumber;
    private MotorBitField m_motorBitField;
    private SpeedLevel m_speedLevel;
    private TachoPulses m_pulsesRampUp;
    private TachoPulses m_pulsesContinue;
    private TachoPulses m_pulsesRampDown;
    private com.ev3opcode.commands.output.arguments.BreakLevel m_breakLevel;

    public MoveStepsSpeed(
            ChainLayerNumber chainLayerNumber,
            MotorBitField motorBitField,
            SpeedLevel speedLevel,
            TachoPulses tachoPulsesRampUp,
            TachoPulses tachoPulsesContinue,
            TachoPulses tachoPulsesRampDown,
            com.ev3opcode.commands.output.arguments.BreakLevel breakLevel) {
        m_chainLayerNumber = chainLayerNumber;
        m_motorBitField = motorBitField;
        m_speedLevel = speedLevel;
        m_pulsesRampUp = tachoPulsesRampUp;
        m_pulsesContinue = tachoPulsesContinue;
        m_pulsesRampDown = tachoPulsesRampDown;
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
        int tachoPulsesRampUpSize = m_pulsesRampUp.getSize();
        int tachoPulsesContinueSize = m_pulsesContinue.getSize();
        int tachoPulsesRampDownSize = m_pulsesRampDown.getSize();
        int breakLevelSize = m_breakLevel.getSize();

        return opCodeSize +
                chainLayerNumberSize +
                motorBitFieldSize +
                speedLevelSize +
                tachoPulsesRampUpSize +
                tachoPulsesContinueSize +
                tachoPulsesRampDownSize +
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
        outputBytes.addAll(Arrays.asList(m_pulsesRampUp.getBytes()));
        outputBytes.addAll(Arrays.asList(m_pulsesContinue.getBytes()));
        outputBytes.addAll(Arrays.asList(m_pulsesRampDown.getBytes()));
        outputBytes.addAll(Arrays.asList(m_breakLevel.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
