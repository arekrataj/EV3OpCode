package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

public final class LongLocalVariable8 extends VariableDataType<Byte> {
    private static byte FLAGS = (byte) 0b11000001;
    private static int SIZE = 2;

    public LongLocalVariable8() {
        super.m_value = 0;
    }

    public LongLocalVariable8(Byte value) {
        setValue(value);
    }

    @Override
    public Byte[] getBytes() {
        return getFilledByteBuffer(FLAGS, super.m_value); // long variable local type, one byte to follow
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return SIZE; // two bytes
    }

    @Override
    public void setValue(Byte value) {
        if (value < -127)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of LongLocalVariable8 type (+/- 127).",
                            value));
        super.m_value = value;
    }
}
