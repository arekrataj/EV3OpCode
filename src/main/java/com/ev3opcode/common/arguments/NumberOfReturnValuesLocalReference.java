package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class NumberOfReturnValuesLocalReference extends ArgumentLocalReference implements NumberOfReturnValues {
    private int m_offsetCached;

    public NumberOfReturnValuesLocalReference(int offset) {
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
