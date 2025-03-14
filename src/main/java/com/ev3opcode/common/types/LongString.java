package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public final class LongString extends DataType<String> {
    private static byte FLAGS = (byte) 0b10000100;

    private byte[] m_stringBytes;

    private void setValue(@NotNull String value) {
        m_stringBytes = value.getBytes(StandardCharsets.US_ASCII);
    }

    private LongString(@NotNull Byte[] bytes) {
        m_stringBytes = new byte[bytes.length];

        for (int i = 0; i < bytes.length; ++i) {
            m_stringBytes[i] = bytes[i];
        }
    }

    public LongString() {
    }

    public LongString(String text) {
        setValue(text);
    }

    @Override
    public Byte[] getBytes() {
        if (m_stringBytes == null)
            return getFilledByteBuffer(FLAGS, (byte) '\0');

        Byte[] tmp = new Byte[m_stringBytes.length + 1];
        int i;

        for (i = 0; i < m_stringBytes.length; ++i)
            tmp[i] = m_stringBytes[i];
        tmp[i] = '\0';

        return getFilledByteBuffer(FLAGS, tmp); // long constant value zero terminated string
    }

    @NotNull
    @Contract(" -> new")
    @Override
    public String getValue() {
        return new String(m_stringBytes);
    }

    @Contract(pure = true)
    @Override
    public int getSize() {
        return m_stringBytes.length + 2; // string length plus flags byte plus termination byte
    }
}
