package com.ev3opcode.commands.input.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentGlobalReference;

public final class DeviceTypeGlobalReference extends ArgumentGlobalReference implements DeviceType {
    private int m_offsetCached;

    public DeviceTypeGlobalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getDeviceTypeOffset() {
        return m_offsetCached;
    }
}
