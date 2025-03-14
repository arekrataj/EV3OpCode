package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class SpeedLevelValue extends ArgumentValue implements SpeedLevel {
    private int m_speedLevelCached;

    public SpeedLevelValue(int level) {
        setSpeedLevel(level);
    }

    @Contract(pure = true)
    public int getSpeedLevel() {
        return m_speedLevelCached;
    }

    public void setSpeedLevel(int level) {
        if (level < -100 || level > 100)
            throw new IllegalArgumentException("Requested speed level exceeds the range of <-100, 100>.");

        super.setValue(level);
        m_speedLevelCached = level;
    }
}
