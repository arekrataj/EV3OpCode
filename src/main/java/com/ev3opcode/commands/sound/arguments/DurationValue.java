package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class DurationValue extends ArgumentValue implements Duration {
    private int m_durationCached;

    public DurationValue(int duration) {
        setDuration(duration);
    }

    @Contract(pure = true)
    public int getDuration() {
        return m_durationCached;
    }

    public void setDuration(int duration) {
        if (duration > 0x7fff)
            throw new RuntimeException("Duration value should fit in 16-bit.");

        super.setValue(duration);
        m_durationCached = duration;
    }
}
