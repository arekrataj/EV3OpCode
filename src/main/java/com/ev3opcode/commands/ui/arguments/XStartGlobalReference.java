package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class XStartGlobalReference extends ArgumentGlobalReference implements XStart {
    private int m_offsetCached;

    public XStartGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getXStartOffset() {
        return m_offsetCached;
    }
}
