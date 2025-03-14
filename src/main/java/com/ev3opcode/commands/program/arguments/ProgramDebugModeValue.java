package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.ev3opcode.commands.program.types.DebugMode;
import com.ev3opcode.common.arguments.ArgumentValue;

public final class ProgramDebugModeValue extends ArgumentValue implements ProgramDebugMode {
    private DebugMode m_debugModeCached;

    public ProgramDebugModeValue(@NotNull DebugMode debugMode) {
        setDebugMode(debugMode);
    }

    @Contract(pure = true)
    public DebugMode getDebugMode() {
        return m_debugModeCached;
    }

    public void setDebugMode(@NotNull DebugMode debugMode) {
        super.setValue(debugMode.getValue());
        m_debugModeCached = debugMode;
    }
}
