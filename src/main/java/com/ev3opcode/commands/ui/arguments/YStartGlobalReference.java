package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class YStartGlobalReference extends ArgumentGlobalReference implements YStart {
    private int m_offsetCached;

    public YStartGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getYStartOffset() {
        return m_offsetCached;
    }
}
