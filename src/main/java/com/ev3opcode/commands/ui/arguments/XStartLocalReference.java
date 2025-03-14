package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class XStartLocalReference extends ArgumentLocalReference implements XStart {
    private int m_offsetCached;

    public XStartLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getXStartOffset() {
        return m_offsetCached;
    }
}
