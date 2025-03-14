package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class PortNumberLocalReference extends ArgumentLocalReference implements PortNumber {
    private int m_offsetCached;

    public PortNumberLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getPortNumberOffset() {
        return m_offsetCached;
    }
}
