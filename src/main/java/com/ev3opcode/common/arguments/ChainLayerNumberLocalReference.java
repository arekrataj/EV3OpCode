package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class ChainLayerNumberLocalReference extends ArgumentLocalReference implements ChainLayerNumber {
    private int m_offsetCached;

    public ChainLayerNumberLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getChainNumberOffset() {
        return m_offsetCached;
    }
}
