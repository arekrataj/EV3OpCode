package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class FrequencyGlobalReference extends ArgumentGlobalReference implements Frequency {
    private int m_offsetCached;

    public FrequencyGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getFrequencyOffset() {
        return m_offsetCached;
    }
}
