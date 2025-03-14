package com.ev3opcode.commands.input.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class DeviceModeGlobalReference extends ArgumentGlobalReference implements DeviceMode {
    private int m_offsetCached;

    public DeviceModeGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getDeviceModeOffset() {
        return m_offsetCached;
    }
}
