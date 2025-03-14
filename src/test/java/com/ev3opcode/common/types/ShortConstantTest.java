package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class ShortConstantTest {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative32_throwsException() {
        new ShortConstant((byte) -32);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setValue_positive32_throwsException() {
        new ShortConstant((byte) 32);
    }

    @Test
    public void getBytes_positive31_flagsSet() {
        ShortConstant sc = new ShortConstant((byte) 31);
        Byte[] bytes = sc.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("00011111", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getBytes_positive6_flagsSet() {
        ShortConstant sc = new ShortConstant((byte) 6);
        Byte[] bytes = sc.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("00000110", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getBytes_negative31_flagsSet() {
        ShortConstant sc = new ShortConstant((byte) -31);
        Byte[] bytes = sc.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("00100001", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getBytes_negative6_flagsSet() {
        ShortConstant sc = new ShortConstant((byte) -6);
        Byte[] bytes = sc.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("00111010", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getBytes_zero_flagsSet() {
        ShortConstant sc = new ShortConstant((byte) 0);
        Byte[] bytes = sc.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void getSize_zero_oneByte() {
        ShortConstant sc = new ShortConstant((byte) 0);
        assertEquals(1, sc.getSize());
    }
}