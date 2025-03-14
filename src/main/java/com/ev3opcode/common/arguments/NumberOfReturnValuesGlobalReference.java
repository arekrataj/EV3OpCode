package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class NumberOfReturnValuesGlobalReference extends ArgumentGlobalReference implements NumberOfReturnValues {
    private int m_offsetCached;

    public NumberOfReturnValuesGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    @Override
    public int getValue() {
        return m_offsetCached;
    }

    @Contract(pure = true)
    @Override
    public boolean isReference() {
        return true;
    }
}
