package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class YSizeGlobalReference extends ArgumentGlobalReference implements YSize {
    private int m_offsetCached;

    public YSizeGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getYSizeOffset() {
        return m_offsetCached;
    }
}
