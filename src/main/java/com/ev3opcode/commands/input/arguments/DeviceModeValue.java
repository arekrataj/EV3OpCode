package com.ev3opcode.commands.input.arguments;

import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class DeviceModeValue extends ArgumentValue implements DeviceMode {
    private com.ev3opcode.commands.input.types.DeviceMode m_deviceModeCached;

    public DeviceModeValue(@NotNull com.ev3opcode.commands.input.types.DeviceMode deviceMode) {
        setDeviceMode(deviceMode);
    }

    public com.ev3opcode.commands.input.types.DeviceMode getDeviceMode() {
        return com.ev3opcode.commands.input.types.DeviceMode.getValueOf(m_deviceModeCached.getValue());
    }

    public void setDeviceMode(@NotNull com.ev3opcode.commands.input.types.DeviceMode deviceMode) {
        super.setValue(deviceMode.getValue());
        m_deviceModeCached = deviceMode;
    }
}
