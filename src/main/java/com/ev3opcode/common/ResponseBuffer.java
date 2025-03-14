package com.ev3opcode.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class ResponseBuffer {
    private Byte[] m_buffer;

    @Contract(pure = true)
    public ResponseBuffer(Byte[] responseBuffer) {
        m_buffer = responseBuffer;
    }

    @NotNull
    public Byte[] read(int startIndex, int length) {
        int endIndex = startIndex + length;
        if ((startIndex >= m_buffer.length) || (endIndex > m_buffer.length))
            throw new RuntimeException(String.format(
                    "Start index %d and/or and length %d exceeds size of the response buffer (%d).",
                    startIndex,
                    length,
                    m_buffer.length));

        return Arrays.copyOfRange(m_buffer, startIndex, endIndex);
    }

    @Contract(pure = true)
    public int getSize() {
        return m_buffer.length;
    }
}
