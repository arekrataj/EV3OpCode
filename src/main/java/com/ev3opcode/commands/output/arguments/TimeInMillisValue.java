package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class TimeInMillisValue extends ArgumentValue implements TimeInMillis {
    private int m_timeInMillisCached;

    public TimeInMillisValue(int millis) {
        setTimeInMillis(millis);
    }

    @Contract(pure = true)
    public int getTimeInMillis() {
        return m_timeInMillisCached;
    }

    public void setTimeInMillis(int millis) {
        super.setValue(millis);
        m_timeInMillisCached = millis;
    }
}
