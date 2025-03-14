package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class ColorGlobalReference extends ArgumentGlobalReference implements Color {
    private int m_offsetCached;

    public ColorGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getColorOffset() {
        return m_offsetCached;
    }
}
