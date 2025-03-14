package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

public final class LongConstant8 extends DataType<Byte> {
    private static byte FLAGS = (byte) 0b10000001; // long constant value type, one byte to follow
    private static int SIZE = 2;

    private void setValue(Byte value) {
        if (value < -127)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of LongConstant8 type (+/- 127).",
                            value));
        super.m_value = value;
    }

    public LongConstant8(Byte value) {
        setValue(value);
    }

    @Override
    public Byte[] getBytes() {
        return getFilledByteBuffer(FLAGS, super.m_value);
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return SIZE; // two bytes
    }
}
