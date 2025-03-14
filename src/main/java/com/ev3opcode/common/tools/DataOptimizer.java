package com.ev3opcode.common.tools;

import org.jetbrains.annotations.Contract;

public final class DataOptimizer {
    @Contract(pure = true)
    public static boolean canBePackedIn5Bits(int value) {
        return ((value >= -31) && (value <= 31));
    }

    @Contract(pure = true)
    public static boolean canBePackedIn8Bits(int value) {
        return ((value >= -127) && (value <= 127));
    }

    @Contract(pure = true)
    public static boolean canBePackedIn16Bits(int value) {
        return ((value >= -32767) && (value <= 32767));
    }
}
