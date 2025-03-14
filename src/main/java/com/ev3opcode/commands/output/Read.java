package com.ev3opcode.commands.output;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import com.ev3opcode.commands.output.arguments.returns.SpeedLevelDataMemoryBlock;
import com.ev3opcode.commands.output.arguments.returns.TachoCountDataMemoryBlock;
import com.ev3opcode.common.Command;
import com.ev3opcode.common.ResponseBuffer;
import com.ev3opcode.common.arguments.ChainLayerNumber;
import com.ev3opcode.common.arguments.PortNumber;
import com.ev3opcode.common.tools.BinaryConverter;

public final class Read extends Command {
    private static byte OPCODE = (byte) 0xA8;

    private ChainLayerNumber m_chainLayerNumber;
    private PortNumber m_portNumber;
    private SpeedLevelDataMemoryBlock m_speedLevelDataMemoryBlock;
    private TachoCountDataMemoryBlock m_tachoCountDataMemoryBlock;

    public final class ReturnedValues {
        private byte m_speedLevel;
        private int m_tachoCount;

        private ReturnedValues(@NotNull ResponseBuffer responseBuffer) {
            Byte[] speedLevelBytes = responseBuffer.read(m_speedLevelDataMemoryBlock.getSpeedLevelOffset(), 1);
            Byte[] tachoCountBytes = responseBuffer.read(m_tachoCountDataMemoryBlock.getTachoCountOffset(), 4);

            m_speedLevel = speedLevelBytes[0];
            m_tachoCount = BinaryConverter.intFromFourBytesLE(tachoCountBytes);
        }

        @Contract(pure = true)
        public byte getSpeedLevel() {
            return m_speedLevel;
        }

        @Contract(pure = true)
        public int getTachoCount() {
            return m_tachoCount;
        }
    }

    public Read(
            ChainLayerNumber chainLayerNumber,
            PortNumber portNumber,
            SpeedLevelDataMemoryBlock speedLevelDataMemoryBlock,
            TachoCountDataMemoryBlock tachoCountDataMemoryBlock) {
        m_chainLayerNumber = chainLayerNumber;
        m_portNumber = portNumber;
        m_speedLevelDataMemoryBlock = speedLevelDataMemoryBlock;
        m_tachoCountDataMemoryBlock = tachoCountDataMemoryBlock;
    }

    @Contract(pure = true)
    @Override
    public Byte getOpCode() {
        return OPCODE;
    }

    @Contract(pure = true)
    @Override
    public int allocatedGlobalBlockSize() {
        int totalGlobalMemoryAllocated = 0;

        if (m_speedLevelDataMemoryBlock.isGlobal())
            totalGlobalMemoryAllocated += 1;
        if (m_tachoCountDataMemoryBlock.isGlobal())
            totalGlobalMemoryAllocated += 4;

        return totalGlobalMemoryAllocated;
    }

    @Contract(pure = true)
    @Override
    public int allocatedLocalBlockSize() {
        int totalLocalMemoryAllocated = 0;

        if (!m_speedLevelDataMemoryBlock.isGlobal())
            totalLocalMemoryAllocated += 1;
        if (!m_tachoCountDataMemoryBlock.isGlobal())
            totalLocalMemoryAllocated += 4;

        return totalLocalMemoryAllocated;
    }

    @Override
    public int getSize() {
        int opCodeSize = 1; // plus 1 for this command opcode
        int chainLayerNumberSize = m_chainLayerNumber.getSize();
        int portNumberSize = m_portNumber.getSize();
        int speedLevelDataMemoryBlockSize = m_speedLevelDataMemoryBlock.getSize();
        int tachoCountDataMemoryBlockSize = m_tachoCountDataMemoryBlock.getSize();

        return opCodeSize +
                chainLayerNumberSize +
                portNumberSize +
                speedLevelDataMemoryBlockSize +
                tachoCountDataMemoryBlockSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.add(this.getOpCode());
        outputBytes.addAll(Arrays.asList(m_chainLayerNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_portNumber.getBytes()));
        outputBytes.addAll(Arrays.asList(m_speedLevelDataMemoryBlock.getBytes()));
        outputBytes.addAll(Arrays.asList(m_tachoCountDataMemoryBlock.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }

    @NotNull
    @Contract("_ -> new")
    public ReturnedValues getReturnedValues(ResponseBuffer responseBuffer) {
        return new ReturnedValues(responseBuffer);
    }
}
