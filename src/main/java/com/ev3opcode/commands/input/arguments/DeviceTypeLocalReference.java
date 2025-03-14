package com.ev3opcode.commands.input.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentLocalReference;

public final class DeviceTypeLocalReference extends ArgumentLocalReference implements DeviceType {
    private int m_offsetCached;

    public DeviceTypeLocalReference(int offset) {
        super(offset);
        m_offsetCached = offset;
    }

    @Contract(pure = true)
    public int getDeviceTypeOffset() {
        return m_offsetCached;
    }
}
