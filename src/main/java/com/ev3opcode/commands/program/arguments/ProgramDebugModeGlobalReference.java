package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class ProgramDebugModeGlobalReference extends ArgumentGlobalReference implements ProgramDebugMode {
    private int m_offsetCached;

    public ProgramDebugModeGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getProgramDebugModeOffset() {
        return m_offsetCached;
    }
}
