package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class TimeInMillisGlobalReference extends ArgumentGlobalReference implements TimeInMillis {
    private int m_offsetCached;

    public TimeInMillisGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getTimeInMillisOffset() {
        return m_offsetCached;
    }
}
