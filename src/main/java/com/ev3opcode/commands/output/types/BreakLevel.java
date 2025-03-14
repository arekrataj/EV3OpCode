package com.ev3opcode.commands.output.types;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum BreakLevel {
    FLOAT((byte) 0x0),
    BREAK((byte) 0x1);

    private static Map<Byte, BreakLevel> m_map = new HashMap<>();
    static {
        for (BreakLevel level : BreakLevel.values())
            m_map.put(level.m_value, level);
    }

    private Byte m_value;

    @Contract(pure = true)
    BreakLevel(Byte value) {
        m_value = value;
    }

    public static BreakLevel getValueOf(Byte value) {
        return (BreakLevel) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
