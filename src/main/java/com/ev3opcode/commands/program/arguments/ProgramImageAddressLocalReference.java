package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class ProgramImageAddressLocalReference extends ArgumentLocalReference implements ProgramImageAddress {
    private int m_offsetCached;

    public ProgramImageAddressLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getImageAddressOffset() {
        return m_offsetCached;
    }
}
