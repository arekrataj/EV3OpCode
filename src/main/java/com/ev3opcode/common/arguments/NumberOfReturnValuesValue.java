package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;

public final class NumberOfReturnValuesValue extends ArgumentValue implements NumberOfReturnValues {
    private int m_numberOfReturnedValuesCached;

    public NumberOfReturnValuesValue(int numberOfReturnValues) {
        if (numberOfReturnValues < 0 || numberOfReturnValues > 127)
            throw new IllegalArgumentException("Number of returned values has to be 8-bit positive value.");

        super.setValue(numberOfReturnValues);
        m_numberOfReturnedValuesCached = numberOfReturnValues;
    }

    @Contract(pure = true)
    @Override
    public int getValue() {
        return m_numberOfReturnedValuesCached;
    }

    @Contract(pure = true)
    @Override
    public boolean isReference() {
        return false;
    }
}
