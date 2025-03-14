package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class TachoPulsesGlobalReference extends ArgumentGlobalReference implements TachoPulses {
    private int m_offsetCached;

    public TachoPulsesGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getTachoPulsesOffset() {
        return m_offsetCached;
    }
}
