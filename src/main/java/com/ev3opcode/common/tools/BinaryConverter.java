package com.ev3opcode.common.tools;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/*
 All bytes are in Little-endian order.
 */
public final class BinaryConverter {
    @NotNull
    @Contract(pure = true)
    private static Byte[] toBytesLE(int numOfBytes, int value) {
        Byte[] resultBytes = new Byte[numOfBytes];
        int i, chunk;

        for (i = 0; i < numOfBytes - 1; ++i) {
            chunk = (value >> (i * 0x8)) & 0xFF;

            resultBytes[i] = (byte) chunk;
        }

        chunk = (value >> (i * 0x8)) & 0xFF;

        resultBytes[i] = (byte) chunk;

        return resultBytes;
    }

    @Contract(pure = true)
    private static int packToInteger(@NotNull Byte[] bytes) {
        int result = 0;
        for (int i = 0; i < bytes.length; ++i) {
            int castedByte = bytes[i] & 0xFF;
            result |= (castedByte << (i * 0x8));
        }

        return result;
    }

    @Contract(pure = true)
    private static int fromBytesLE(@NotNull Byte... bytes) {
        return packToInteger(bytes);
    }

    @NotNull
    @Contract(pure = true)
    public static Byte unpackFrom5Bits(Byte byteCode) {
        if ((byteCode & 0x20) != 0) // negative number?
            return (byte) (byteCode | 0xC0);

        return byteCode;
    }

    @NotNull
    public static Byte packTo5Bits(Byte value) {
        if (value < -31 || value > 31)
            throw new IllegalArgumentException(
                    String.format(
                            "The value of %d exceeds the range of 5-bit SMR value type (+/- 31).",
                            value));

        return (byte) (value & 0x3F);
    }

    @NotNull
    public static Byte[] shortToTwoBytesLE(Short value) {
        if (value < -32767)
            throw new IllegalArgumentException(String.format("Cannot convert short value of %d to SMR 2-byte.", value));

        return toBytesLE(2, value);
    }

    @NotNull
    public static Short shortFromTwoBytesLE(@NotNull Byte[] bytes) {
        if (bytes.length > 2)
            throw new IllegalArgumentException("Too many bytes for Short type.");

        return (short) fromBytesLE(bytes);
    }

    @NotNull
    public static Byte[] intToFourBytesLE(Integer value) {
        if (value < -2147483647)
            throw new IllegalArgumentException(
                    String.format("Cannot convert integer value of %d to SMR 4-byte.", value));

        return toBytesLE(4, value);
    }

    @NotNull
    public static Integer intFromFourBytesLE(@NotNull Byte[] bytes) {
        if (bytes.length > 4)
            throw new IllegalArgumentException("Too many bytes for Integer type.");

        return fromBytesLE(bytes);
    }

    @NotNull
    public static Float floatFromFourBytesLE(Byte[] bytes) {
        int bits = packToInteger(bytes);
        return Float.intBitsToFloat(bits);
    }
}
