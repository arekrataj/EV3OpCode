package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.returns.ReturnedDataMemoryBlock;
import com.ev3opcode.common.types.DataType;

public abstract class SpeedLevelDataMemoryBlock implements ReturnedDataMemoryBlock {
    DataType<?> m_speedLevelOffset;

    public abstract int getSpeedLevelOffset();

    @Override
    public int getSize() {
        return m_speedLevelOffset.getSize();
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        return m_speedLevelOffset.getBytes();
    }
}
