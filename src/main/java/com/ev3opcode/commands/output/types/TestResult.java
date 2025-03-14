package com.ev3opcode.commands.output.types;

import org.jetbrains.annotations.Contract;

public final class TestResult {
    private byte m_flags;

    @Contract(pure = true)
    public TestResult(byte flags) {
        m_flags = flags;
    }

    @Contract(pure = true)
    public boolean isBusyPortA() {
        return (m_flags & 0x1) != 0;
    }

    @Contract(pure = true)
    public boolean isBusyPortB() {
        return (m_flags & 0x2) != 0;
    }

    @Contract(pure = true)
    public boolean isBusyPortC() {
        return (m_flags & 0x4) != 0;
    }

    @Contract(pure = true)
    public boolean isBusyPortD() {
        return (m_flags & 0x8) != 0;
    }
}