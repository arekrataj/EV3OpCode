package com.ev3opcode.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.tools.BinaryConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DirectCommand implements ByteCode {
    private short m_messageNumber;
    private DirectCommandType m_commandType;
    private int m_allocatedGlobalBlockSize = 0;
    private int m_allocatedLocalBlockSize = 0;
    private List<Command> m_commands = new ArrayList<>();

    @NotNull
    @Contract(value = " -> new", pure = true)
    private Byte[] prepareAllocationBytes() {
        short allocatedGlobals = (short) (m_allocatedGlobalBlockSize & 0x3FF);
        short allocatedLocals = (short) (m_allocatedLocalBlockSize & 0x3F);
        short packed = (short) (allocatedGlobals | (allocatedLocals << 0xA));

        return BinaryConverter.shortToTwoBytesLE(packed);
    }

    public DirectCommand(short messageNumber, DirectCommandType commandType) {
        m_messageNumber = messageNumber;
        m_commandType = commandType;
    }

    @Override
    public int getSize() {
        int totalSize = 5; // message counter (2 bytes) + type (1 byte) + allocations (2 bytes)

        for (Command cmd : m_commands)
            totalSize += cmd.getSize();

        return totalSize;
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        ArrayList<Byte> outputBytes = new ArrayList<>();

        outputBytes.addAll(Arrays.asList(BinaryConverter.shortToTwoBytesLE((short) getSize())));
        outputBytes.addAll(Arrays.asList(BinaryConverter.shortToTwoBytesLE(m_messageNumber)));
        outputBytes.add(m_commandType.getValue());
        outputBytes.addAll(Arrays.asList(prepareAllocationBytes()));

        for (Command cmd : m_commands)
            outputBytes.addAll(Arrays.asList(cmd.getBytes()));

        return outputBytes.toArray(new Byte[0]);
    }

    @Contract(pure = true)
    public short getMessageNumber() {
        return m_messageNumber;
    }

    @Contract(pure = true)
    public DirectCommandType getCommandType() {
        return m_commandType;
    }

    public void setCommanType(DirectCommandType type) {
        m_commandType = type;
    }

    public void addCommand(@NotNull Command command) {
        int allocatedGlobalBlockSize = command.allocatedGlobalBlockSize();
        int allocatedLocalBlockSize = command.allocatedLocalBlockSize();

        if (allocatedGlobalBlockSize + m_allocatedGlobalBlockSize > 1024)
            throw new RuntimeException("Cannot allocate more than 1024 bytes of global memory block.");

        if (allocatedLocalBlockSize + m_allocatedLocalBlockSize > 64)
            throw new RuntimeException("Cannot allocate more than 64 bytes of local memory block.");

        m_allocatedGlobalBlockSize += allocatedGlobalBlockSize;
        m_allocatedLocalBlockSize += allocatedLocalBlockSize;

        m_commands.add(command);
    }
}
