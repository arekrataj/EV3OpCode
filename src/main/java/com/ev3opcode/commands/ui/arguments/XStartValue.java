package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class XStartValue extends ArgumentValue implements XStart {
    private int m_xStartCached;

    public XStartValue(int xStart) {
        setXStart(xStart);
    }

    @Contract(pure = true)
    public int getXStart() {
        return m_xStartCached;
    }

    public void setXStart(int xStart) {
        if (xStart < 0 || xStart > 177)
            throw new RuntimeException("Incorrect X-start value. It should fit in range of 0-177.");

        super.setValue(xStart);
        m_xStartCached = xStart;
    }
}
