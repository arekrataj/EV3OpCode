package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class BreakLevelLocalReference extends ArgumentLocalReference implements BreakLevel {
    private int m_offsetCached;

    public BreakLevelLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getBreakLevelOffset() {
        return m_offsetCached;
    }
}
