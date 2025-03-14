package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class ProgramIdLocalReference extends ArgumentLocalReference implements ProgramId {
    private int m_offsetCached;

    public ProgramIdLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getProgramIdOffset() {
        return m_offsetCached;
    }
}
