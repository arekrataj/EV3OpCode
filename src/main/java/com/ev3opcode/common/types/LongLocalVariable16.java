package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.BinaryConverter;

public final class LongLocalVariable16 extends VariableDataType<Short> {
    private static byte FLAGS = (byte) 0b11000010;
    private static int SIZE = 3;

    public LongLocalVariable16() {
        super.m_value = 0;
    }

    public LongLocalVariable16(Short value) {
        setValue(value);
    }

    @Override
    public Byte[] getBytes() {
        Byte[] convertedBytes = BinaryConverter.shortToTwoBytesLE(super.m_value);

        return getFilledByteBuffer(FLAGS, convertedBytes); // long variable local type, two bytes to follow
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return SIZE; // three bytes
    }

    @Override
    public void setValue(Short value) {
        if (value < -32767)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of LongLocalVariable16 type (+/- 32767).",
                            value));
        super.m_value = value;
    }
}
