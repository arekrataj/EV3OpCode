package com.ev3opcode.commands.ui.types;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    WHITE((byte) 0x0),
    BLACK((byte) 0x1);

    private static Map<Byte, Color> m_map = new HashMap<>();
    static {
        for (Color color : Color.values())
            m_map.put(color.m_value, color);
    }

    private Byte m_value;

    @Contract(pure = true)
    Color(Byte value) {
        m_value = value;
    }

    public static Color getValueOf(Byte value) {
        return (Color) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
