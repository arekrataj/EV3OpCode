package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class MotorBitFieldGlobalReference extends ArgumentGlobalReference implements MotorBitField {
    private int m_offsetCached;

    public MotorBitFieldGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getMotorBitFieldOffset() {
        return m_offsetCached;
    }
}
