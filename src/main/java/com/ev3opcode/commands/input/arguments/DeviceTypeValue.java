package com.ev3opcode.commands.input.arguments;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class DeviceTypeValue extends ArgumentValue implements DeviceType {
    private int m_deviceTypeCached;

    public DeviceTypeValue(int deviceType) {
        setDeviceType(deviceType);
    }

    @Contract(pure = true)
    public int getDeviceType() {
        return m_deviceTypeCached;
    }

    public void setDeviceType(int deviceType) {
        super.setValue(deviceType);
        m_deviceTypeCached = deviceType;
    }
}
