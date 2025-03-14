package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class VolumeValue extends ArgumentValue implements Volume {
    private int m_volumeCached;

    public VolumeValue(int volume) {
        setVolume(volume);
    }

    @Contract(pure = true)
    public int getVolume() {
        return m_volumeCached;
    }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 100)
            throw new RuntimeException("Invalid volume parameter value (0-100).");

        super.setValue(volume);
        m_volumeCached = volume;
    }
}
