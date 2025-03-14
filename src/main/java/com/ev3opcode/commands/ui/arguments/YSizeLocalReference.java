package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class YSizeLocalReference extends ArgumentLocalReference implements YSize {
    private int m_offsetCached;

    public YSizeLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getYSizeOffset() {
        return m_offsetCached;
    }
}
