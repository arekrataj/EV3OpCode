package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.BinaryConverter;

public final class LongLocalVariable32 extends VariableDataType<Integer> {
    private static byte FLAGS = (byte) 0b11000011;
    private static int SIZE = 5;

    public LongLocalVariable32() {
        super.m_value = 0;
    }

    public LongLocalVariable32(Integer value) {
        setValue(value);
    }

    @Override
    public Byte[] getBytes() {
        Byte[] convertedBytes = BinaryConverter.intToFourBytesLE(super.m_value);

        return getFilledByteBuffer(FLAGS, convertedBytes); // long variable local type, four bytes to follow
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return SIZE; // five bytes
    }

    @Override
    public void setValue(Integer value) {
        if (value < -2147483647)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of LongLocalVariable32 type (+/- 2147483647).",
                            value));
        super.m_value = value;
    }
}
