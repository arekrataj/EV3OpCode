package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class PowerLevelGlobalReference extends ArgumentGlobalReference implements PowerLevel {
    private int m_offsetCached;

    public PowerLevelGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getPowerLevelOffset() {
        return m_offsetCached;
    }
}
