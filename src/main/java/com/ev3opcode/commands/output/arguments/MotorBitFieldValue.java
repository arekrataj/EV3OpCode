package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class MotorBitFieldValue extends ArgumentValue implements MotorBitField {
    @Contract(pure = true)
    private static int prepareFlags(boolean setMotorA, boolean setMotorB, boolean setMotorC, boolean setMotorD) {
        byte field = 0;

        if (setMotorA)
            field |= 0x1;
        if (setMotorB)
            field |= 0x2;
        if (setMotorC)
            field |= 0x4;
        if (setMotorD)
            field |= 0x8;

        return field & 0xF;
    }

    private boolean m_setMotorACached;
    private boolean m_setMotorBCached;
    private boolean m_setMotorCCached;
    private boolean m_setMotorDCached;

    public MotorBitFieldValue(boolean setMotorA, boolean setMotorB, boolean setMotorC, boolean setMotorD) {
        setMotors(setMotorA, setMotorB, setMotorC, setMotorD);
    }

    public void setMotors(boolean setMotorA, boolean setMotorB, boolean setMotorC, boolean setMotorD) {
        super.setValue(prepareFlags(setMotorA, setMotorB, setMotorC, setMotorD));

        m_setMotorACached = setMotorA;
        m_setMotorBCached = setMotorB;
        m_setMotorCCached = setMotorC;
        m_setMotorDCached = setMotorD;
    }

    @Contract(pure = true)
    public boolean isSetMotorA() {
        return m_setMotorACached;
    }

    @Contract(pure = true)
    public boolean isSetMotorB() {
        return m_setMotorBCached;
    }

    @Contract(pure = true)
    public boolean isSetMotorC() {
        return m_setMotorCCached;
    }

    @Contract(pure = true)
    public boolean isSetMotorD() {
        return m_setMotorDCached;
    }
}
