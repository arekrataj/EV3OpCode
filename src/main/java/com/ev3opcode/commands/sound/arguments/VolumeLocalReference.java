package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class VolumeLocalReference extends ArgumentLocalReference implements Volume {
    private int m_offsetCached;

    public VolumeLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getVolumeOffset() {
        return m_offsetCached;
    }
}
