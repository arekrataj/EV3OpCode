package com.ev3opcode.commands.input.types;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum DeviceMode {
    ZERO((byte) 0x0),
    ONE((byte) 0x1),
    TWO((byte) 0x2),
    THREE((byte) 0x3),
    FOUR((byte) 0x4),
    FIVE((byte) 0x5),
    SIX((byte) 0x6),
    SEVEN((byte) 0x7),
    NO_CHANGE((byte) 0x80);

    private static Map<Byte, DeviceMode> m_map = new HashMap<>();
    static {
        for (DeviceMode mode : DeviceMode.values())
            m_map.put(mode.m_value, mode);
    }

    private Byte m_value;

    @Contract(pure = true)
    DeviceMode(Byte value) {
        m_value = value;
    }

    public static DeviceMode getValueOf(Byte value) {
        return (DeviceMode) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
