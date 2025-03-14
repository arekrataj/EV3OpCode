package com.ev3opcode.commands.program.types;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum ProgramID {
    GUI_SLOT((short) 0x0),
    USER_SLOT((short) 0x1),
    CMD_SLOT((short) 0x2),
    TERM_SLOT((short) 0x3),
    DEBUG_SLOT((short) 0x4);

    private static Map<Short, ProgramID> m_map = new HashMap<>();
    static {
        for (ProgramID id : ProgramID.values())
            m_map.put(id.m_value, id);
    }

    private Short m_value;

    @Contract(pure = true)
    ProgramID(Short value) {
        m_value = value;
    }

    public static ProgramID getValueOf(Short value) {
        return (ProgramID) m_map.get(value);
    }

    @Contract(pure = true)
    public Short getValue() {
        return m_value;
    }
}
