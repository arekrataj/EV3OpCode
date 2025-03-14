package com.ev3opcode.commands.input.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeviceTypeValueTest {
    private DeviceTypeValue m_deviceType;

    @Before
    public void setUp() throws Exception {
        m_deviceType = new DeviceTypeValue(1);
    }

    @Test
    public void getDeviceType_returns1() {
        assertEquals(1, m_deviceType.getDeviceType());
    }

    @Test
    public void setDeviceType_10_setsValue() {
        m_deviceType.setDeviceType(10);
        assertEquals(10, m_deviceType.getDeviceType());
    }
}