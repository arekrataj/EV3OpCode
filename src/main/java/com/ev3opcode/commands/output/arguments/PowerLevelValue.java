package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class PowerLevelValue extends ArgumentValue implements PowerLevel {
    private int m_powerLevelCached;

    public PowerLevelValue(int level) {
        setPowerLevel(level);
    }

    @Contract(pure = true)
    public int getPowerLevel() {
        return m_powerLevelCached;
    }

    public void setPowerLevel(int level) {
        if (level < -100 || level > 100)
            throw new IllegalArgumentException("Requested power level exceeds the range of <-100, 100>.");

        super.setValue(level);
        m_powerLevelCached = level;
    }
}
