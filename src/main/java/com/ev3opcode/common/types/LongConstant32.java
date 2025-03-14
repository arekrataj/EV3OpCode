package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.BinaryConverter;

public final class LongConstant32 extends DataType<Integer> {
    private static byte FLAGS = (byte) 0b10000011;
    private static int SIZE = 5;

    private void setValue(Integer value) {
        if (value < -2147483647)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of LongConstant32 type (+/- 2147483647).",
                            value));
        super.m_value = value;
    }

    public LongConstant32(Integer value) {
        setValue(value);
    }

    @Override
    public Byte[] getBytes() {
        Byte[] convertedBytes = BinaryConverter.intToFourBytesLE(super.m_value);

        return getFilledByteBuffer(FLAGS, convertedBytes); // long constant value type, four bytes to follow
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return SIZE; // five bytes
    }
}
