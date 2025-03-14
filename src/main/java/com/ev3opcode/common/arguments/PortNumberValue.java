package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.NotNull;

public final class PortNumberValue extends ArgumentValue implements PortNumber {
    private com.ev3opcode.common.types.PortNumber m_portNumberCached;

    public PortNumberValue(@NotNull com.ev3opcode.common.types.PortNumber portNumber) {
        setPortNumber(portNumber);
    }

    public com.ev3opcode.common.types.PortNumber getPortNumber() {
        return com.ev3opcode.common.types.PortNumber.getValueOf(m_portNumberCached.getValue());
    }

    public void setPortNumber(@NotNull com.ev3opcode.common.types.PortNumber portNumber) {
        super.setValue(portNumber.getValue());
        m_portNumberCached = portNumber;
    }
}
