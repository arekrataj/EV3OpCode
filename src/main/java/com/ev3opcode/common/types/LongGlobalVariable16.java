package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.BinaryConverter;

public final class LongGlobalVariable16 extends VariableDataType<Short> {
    private static byte FLAGS = (byte) 0b11100010;
    private static int SIZE = 3;

    public LongGlobalVariable16() {
        super.m_value = 0;
    }

    public LongGlobalVariable16(Short value) {
        setValue(value);
    }

    @Override
    public Byte[] getBytes() {
        Byte[] convertedBytes = BinaryConverter.shortToTwoBytesLE(super.m_value);

        return getFilledByteBuffer(FLAGS, convertedBytes); // long variable global type, two bytes to follow
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
                            "The value of %d exceeds the range of LongGlobalVariable16 type (+/- 32767).",
                            value));
        super.m_value = value;
    }
}
