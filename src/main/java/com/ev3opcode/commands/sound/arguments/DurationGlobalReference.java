package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class DurationGlobalReference extends ArgumentGlobalReference implements Duration {
    private int m_offsetCached;

    public DurationGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getDurationOffset() {
        return m_offsetCached;
    }
}
