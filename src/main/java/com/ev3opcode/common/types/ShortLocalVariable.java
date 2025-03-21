package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.tools.BinaryConverter;

public final class ShortLocalVariable extends VariableDataType<Byte> {
    private static byte FLAGS = (byte) 0b01000000;
    private static int SIZE = 1;

    public ShortLocalVariable() {
        super.m_value = 0;
    }

    public ShortLocalVariable(Byte value) {
        setValue(value);
    }

    @Contract(" -> new")
    @NotNull
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

    @Override
    public void setValue(Byte value) {
        if (value < 0 || value > 31)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d is out of range of ShortLocalVariable type (max 31).",
                            value));

        super.m_value = value;
    }
}
