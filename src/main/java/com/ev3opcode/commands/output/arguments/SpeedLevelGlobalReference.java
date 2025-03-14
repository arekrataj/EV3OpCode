package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class SpeedLevelGlobalReference extends ArgumentGlobalReference implements SpeedLevel {
    private int m_offsetCached;

    public SpeedLevelGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getSpeedLevelOffset() {
        return m_offsetCached;
    }
}
