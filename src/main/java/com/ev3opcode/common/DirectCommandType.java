package com.ev3opcode.common;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum DirectCommandType {
    REPLY_REQUIRED((byte) 0x0),
    NO_REPLY_REQUIRED((byte) 0x80);

    private static Map<Byte, DirectCommandType> m_map = new HashMap<>();
    static {
        for (DirectCommandType mode : DirectCommandType.values())
            m_map.put(mode.m_value, mode);
    }

    private Byte m_value;

    @Contract(pure = true)
    DirectCommandType(Byte value) {
        m_value = value;
    }

    public static DirectCommandType getValueOf(Byte value) {
        return (DirectCommandType) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
