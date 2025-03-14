package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class MotorBitFieldLocalReference extends ArgumentLocalReference implements MotorBitField {
    private int m_offsetCached;

    public MotorBitFieldLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getMotorBitFieldOffset() {
        return m_offsetCached;
    }
}
