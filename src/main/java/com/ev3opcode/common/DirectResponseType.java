package com.ev3opcode.common;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum DirectResponseType {
    OK((byte) 0x2),
    ERROR((byte) 0x4);

    private static Map<Byte, DirectResponseType> m_map = new HashMap<>();
    static {
        for (DirectResponseType mode : DirectResponseType.values())
            m_map.put(mode.m_value, mode);
    }

    private Byte m_value;

    @Contract(pure = true)
    DirectResponseType(Byte value) {
        m_value = value;
    }

    public static DirectResponseType getValueOf(Byte value) {
        return (DirectResponseType) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
