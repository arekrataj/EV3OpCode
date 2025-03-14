package com.ev3opcode.helpers;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;

public class ArraysHelper {
    public static <T> T[] concatenate(@NotNull T[] a, @NotNull T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }
}
