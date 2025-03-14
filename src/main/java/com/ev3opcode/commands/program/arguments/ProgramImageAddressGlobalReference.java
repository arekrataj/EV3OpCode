package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class ProgramImageAddressGlobalReference extends ArgumentGlobalReference implements ProgramImageAddress {
    private int m_offsetCached;

    public ProgramImageAddressGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getImageAddressOffset() {
        return m_offsetCached;
    }
}
