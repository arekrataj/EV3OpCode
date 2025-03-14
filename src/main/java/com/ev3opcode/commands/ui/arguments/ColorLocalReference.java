package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class ColorLocalReference extends ArgumentLocalReference implements Color {
    private int m_offsetCached;

    public ColorLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getColorOffset() {
        return m_offsetCached;
    }
}
