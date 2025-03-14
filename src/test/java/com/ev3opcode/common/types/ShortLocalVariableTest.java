package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class ShortLocalVariableTest {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative_throwsException() {
        ShortLocalVariable sv = new ShortLocalVariable();
        sv.setValue((byte) -32);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setValue_positive32_throwsException() {
        ShortLocalVariable sv = new ShortLocalVariable();
        sv.setValue((byte) 32);
    }

    @Test
    public void getBytes_positive31_flagsSet() {
        ShortLocalVariable sv = new ShortLocalVariable((byte) 31);
        Byte[] bytes = sv.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("01011111", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getBytes_zero_flagsSet() {
        ShortLocalVariable sv = new ShortLocalVariable((byte) 0);
        Byte[] bytes = sv.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("01000000", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getSize_zero_oneByte() {
        ShortLocalVariable sv = new ShortLocalVariable((byte) 0);
        assertEquals(1, sv.getSize());
    }
}