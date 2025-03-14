package com.ev3opcode.commands.input.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class DeviceModeLocalReference extends ArgumentLocalReference implements DeviceMode {
    private int m_offsetCached;

    public DeviceModeLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getDeviceModeOffset() {
        return m_offsetCached;
    }
}
