package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class YSizeValue extends ArgumentValue implements YSize {
    private int m_ySizeCached;

    public YSizeValue(int ySize) {
        setYSize(ySize);
    }

    @Contract(pure = true)
    public int getYSize() {
        return m_ySizeCached;
    }

    public void setYSize(int ySize) {
        if (ySize > 0x7fff)
            throw new RuntimeException("Y-size value should fit in 16-bit.");

        super.setValue(ySize);
        m_ySizeCached = ySize;
    }
}
