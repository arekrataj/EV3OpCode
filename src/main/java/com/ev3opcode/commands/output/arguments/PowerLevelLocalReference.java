package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class PowerLevelLocalReference extends ArgumentLocalReference implements PowerLevel {
    private int m_offsetCached;

    public PowerLevelLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getPowerLevelOffset() {
        return m_offsetCached;
    }
}
