package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class FrequencyLocalReference extends ArgumentLocalReference implements Frequency {
    private int m_offsetCached;

    public FrequencyLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getFrequencyOffset() {
        return m_offsetCached;
    }
}
