package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.BinaryConverter;

public final class LongConstant16 extends DataType<Short> {
    private static byte FLAGS = (byte) 0b10000010;
    private static int SIZE = 3;

    private void setValue(Short value) {
        if (value < -32767)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of LongConstant16 type (+/- 32767).",
                            value));
        super.m_value = value;
    }

    public LongConstant16(Short value) {
        setValue(value);
    }

    @Override
    public Byte[] getBytes() {
        Byte[] convertedBytes = BinaryConverter.shortToTwoBytesLE(super.m_value);

        return getFilledByteBuffer(FLAGS, convertedBytes); // long constant value type, two bytes to follow
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return SIZE; // three bytes
    }
}
