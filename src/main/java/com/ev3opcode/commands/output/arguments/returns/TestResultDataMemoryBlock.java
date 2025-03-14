package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.returns.ReturnedDataMemoryBlock;
import com.ev3opcode.common.types.DataType;

public abstract class TestResultDataMemoryBlock implements ReturnedDataMemoryBlock {
    DataType<?> m_testResultOffset;

    public abstract int getTestResultOffset();

    @Override
    public int getSize() {
        return m_testResultOffset.getSize();
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        return m_testResultOffset.getBytes();
    }
}
