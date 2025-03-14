package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum PortNumber {
    ONE((byte) 0x0),
    TWO((byte) 0x1),
    THREE((byte) 0x2),
    FOUR((byte) 0x3);

    private static Map<Byte, PortNumber> m_map = new HashMap<>();
    static {
        for (PortNumber portNumber : PortNumber.values())
            m_map.put(portNumber.m_value, portNumber);
    }

    private Byte m_value;

    @Contract(pure = true)
    PortNumber(Byte value) {
        m_value = value;
    }

    public static PortNumber getValueOf(Byte value) {
        return (PortNumber) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
