package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class ShortGlobalVariableTest {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative_throwsException() {
        ShortGlobalVariable sg = new ShortGlobalVariable();
        sg.setValue((byte) -32);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setValue_positive32_throwsException() {
        ShortGlobalVariable sg = new ShortGlobalVariable();
        sg.setValue((byte) 32);
    }

    @Test
    public void getBytes_positive31_flagsSet() {
        ShortGlobalVariable sg = new ShortGlobalVariable((byte) 31);
        Byte[] bytes = sg.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("01111111", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getBytes_zero_flagsSet() {
        ShortGlobalVariable sg = new ShortGlobalVariable((byte) 0);
        Byte[] bytes = sg.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("01100000", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getSize_zero_oneByte() {
        ShortGlobalVariable sg = new ShortGlobalVariable((byte) 0);
        assertEquals(1, sg.getSize());
    }
}