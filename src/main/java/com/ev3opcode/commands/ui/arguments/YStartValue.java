package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class YStartValue extends ArgumentValue implements YStart {
    private int m_yStartCached;

    public YStartValue(int yStart) {
        setYStart(yStart);
    }

    @Contract(pure = true)
    public int getYStart() {
        return m_yStartCached;
    }

    public void setYStart(int yStart) {
        if (yStart < 0 || yStart > 127)
            throw new RuntimeException("Incorrect Y-start value. It should fit in range of 0-127.");

        super.setValue(yStart);
        m_yStartCached = yStart;
    }
}
