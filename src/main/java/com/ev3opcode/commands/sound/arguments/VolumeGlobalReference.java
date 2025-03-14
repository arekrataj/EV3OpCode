package com.ev3opcode.commands.sound.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class VolumeGlobalReference extends ArgumentGlobalReference implements Volume {
    private int m_offsetCached;

    public VolumeGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getVolumeOffset() {
        return m_offsetCached;
    }
}
