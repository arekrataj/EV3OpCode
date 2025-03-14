package com.ev3opcode.commands.output.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class TachoPulsesValue extends ArgumentValue implements TachoPulses {
    private int m_tachoPulsesCached;

    public TachoPulsesValue(int pulses) {
        setTachoPulses(pulses);
    }

    @Contract(pure = true)
    public int getTachoPulses() {
        return m_tachoPulsesCached;
    }

    public void setTachoPulses(int pulses) {
        super.setValue(pulses);
        m_tachoPulsesCached = pulses;
    }
}
