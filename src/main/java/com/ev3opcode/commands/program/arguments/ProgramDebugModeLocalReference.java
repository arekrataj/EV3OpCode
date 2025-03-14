package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class ProgramDebugModeLocalReference extends ArgumentLocalReference implements ProgramDebugMode {
    private int m_offsetCached;

    public ProgramDebugModeLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getProgramDebugModeOffset() {
        return m_offsetCached;
    }
}
