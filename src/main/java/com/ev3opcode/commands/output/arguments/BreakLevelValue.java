package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class BreakLevelValue extends ArgumentValue implements BreakLevel {
    private com.ev3opcode.commands.output.types.BreakLevel m_breakLevelCached;

    public BreakLevelValue(@NotNull com.ev3opcode.commands.output.types.BreakLevel breakLevel) {
        setBreakLevel(breakLevel);
    }

    public com.ev3opcode.commands.output.types.BreakLevel getBreakLevel() {
        return com.ev3opcode.commands.output.types.BreakLevel.getValueOf(m_breakLevelCached.getValue());
    }

    public void setBreakLevel(@NotNull com.ev3opcode.commands.output.types.BreakLevel breakLevel) {
        super.setValue(breakLevel.getValue());
        m_breakLevelCached = breakLevel;
    }
}
