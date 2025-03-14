package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class SpeedLevelLocalReference extends ArgumentLocalReference implements SpeedLevel {
    private int m_offsetCached;

    public SpeedLevelLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getSpeedLevelOffset() {
        return m_offsetCached;
    }
}
