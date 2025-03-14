package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.returns.ReturnedDataMemoryBlock;
import com.ev3opcode.common.types.DataType;

public abstract class TachoCountDataMemoryBlock implements ReturnedDataMemoryBlock {
    DataType<?> m_tachoCountOffset;

    public abstract int getTachoCountOffset();

    @Override
    public int getSize() {
        return m_tachoCountOffset.getSize();
    }

    @NotNull
    @Override
    public Byte[] getBytes() {
        return m_tachoCountOffset.getBytes();
    }
}
