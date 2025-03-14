package com.ev3opcode.commands.program.types;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum DebugMode {
    NORMAL((byte) 0x0),
    DEBUG((byte) 0x1),
    DO_NOT_EXECUTE((byte) 0x2);

    private static Map<Byte, DebugMode> m_map = new HashMap<>();
    static {
        for (DebugMode mode : DebugMode.values())
            m_map.put(mode.m_value, mode);
    }

    private Byte m_value;

    @Contract(pure = true)
    DebugMode(Byte value) {
        m_value = value;
    }

    public static DebugMode getValueOf(Byte value) {
        return (DebugMode) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
