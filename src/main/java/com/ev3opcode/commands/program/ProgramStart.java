package com.ev3opcode.commands.program;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.program.arguments.ProgramDebugMode;
import com.ev3opcode.commands.program.arguments.ProgramId;
import com.ev3opcode.commands.program.arguments.ProgramImageAddress;
import com.ev3opcode.commands.program.arguments.ProgramImageSize;
import com.ev3opcode.common.Command;

public final class ProgramStart extends Command {
    private static byte OPCODE = 0x3;

    private ProgramId m_programId;
    private ProgramImageSize m_imageSize;
    private ProgramImageAddress m_imageAddress;
    private ProgramDebugMode m_debugMode;

    public ProgramStart(
            ProgramId programId,
            ProgramImageSize imageSize,
            ProgramImageAddress imageAddress,
            ProgramDebugMode debugMode) {
        m_programId = programId;
        m_imageSize = imageSize;
        m_imageAddress = imageAddress;
        m_debugMode = debugMode;
    }

    @NotNull
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
        int programIdSize = m_programId.getSize();
        int imageSizeSize = m_imageSize.getSize();
        int imageAddressSize = m_imageAddress.getSize();
        int debugModeSize = m_debugMode.getSize();

        return opCodeSize + programIdSize + imageSizeSize + imageAddressSize + debugModeSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(getOpCode());
        outputBytes.addAll(Arrays.asList(m_programId.getBytes()));
        outputBytes.addAll(Arrays.asList(m_imageSize.getBytes()));
        outputBytes.addAll(Arrays.asList(m_imageAddress.getBytes()));
        outputBytes.addAll(Arrays.asList(m_debugMode.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }
}
