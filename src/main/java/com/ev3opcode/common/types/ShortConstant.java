package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.tools.BinaryConverter;

public final class ShortConstant extends DataType<Byte> {
    private static byte FLAGS = (byte) 0b0;
    private static int SIZE = 1;

    private void setValue(Byte value) {
        if (value < -31 || value > 31)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of ShortConstant type (+/- 31).",
                            value));
        super.m_value = value;
    }

    public ShortConstant(Byte value) {
        setValue(value);
    }

    @NotNull
    @Contract(" -> new")
    @Override
    public Byte[] getBytes() {
        byte value = BinaryConverter.packTo5Bits(super.m_value);

        value |= FLAGS;

        return new Byte[] { value };
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return SIZE; // one byte
    }
}
