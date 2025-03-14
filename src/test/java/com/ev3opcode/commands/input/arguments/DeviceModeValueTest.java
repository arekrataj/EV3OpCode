package com.ev3opcode.commands.input.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.commands.input.types.DeviceMode;

import static org.junit.Assert.assertEquals;

public class DeviceModeValueTest {
    private DeviceModeValue m_deviceMode;

    @Before
    public void setUp() throws Exception {
        m_deviceMode = new DeviceModeValue(DeviceMode.SIX);
    }

    @Test
    public void getDeviceMode_returnsSix() {
        assertEquals(DeviceMode.SIX, m_deviceMode.getDeviceMode());
    }

    @Test
    public void setDeviceMode_one_setsValue() {
        m_deviceMode.setDeviceMode(DeviceMode.ONE);
        assertEquals(DeviceMode.ONE, m_deviceMode.getDeviceMode());
    }
}