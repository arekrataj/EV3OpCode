package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class FrequencyValue extends ArgumentValue implements Frequency {
    private int m_frequencyCached;

    public FrequencyValue(int frequency) {
        setFrequency(frequency);
    }

    @Contract(pure = true)
    public int getFrequency() {
        return m_frequencyCached;
    }

    public void setFrequency(int frequency) {
        if (frequency < 250 || frequency > 10000)
            throw new RuntimeException("Invalid volume frequency value (250-10000).");

        super.setValue(frequency);
        m_frequencyCached = frequency;
    }
}
