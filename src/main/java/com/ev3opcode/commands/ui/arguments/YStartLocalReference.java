package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class YStartLocalReference extends ArgumentLocalReference implements YStart {
    private int m_offsetCached;

    public YStartLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getYStartOffset() {
        return m_offsetCached;
    }
}
