package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class ChainLayerNumberGlobalReference extends ArgumentGlobalReference implements ChainLayerNumber {
    private int m_offsetCached;

    public ChainLayerNumberGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getChainNumberOffset() {
        return m_offsetCached;
    }
}
