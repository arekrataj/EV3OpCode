package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class LongConstant8Test {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative128_throwsException() {
        new LongConstant8((byte) -128);
    }

    @Test
    public void getBytes_zero_followingByte() {
        LongConstant8 lc8 = new LongConstant8((byte) 0);
        Byte[] b = lc8.getBytes();
        assertEquals(2, b.length);
        assertEquals("10000001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getBytes_positive70_followingByte() {
        LongConstant8 lc8 = new LongConstant8((byte) 70);
        Byte[] b = lc8.getBytes();
        assertEquals(2, b.length);
        assertEquals("10000001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("01000110", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getBytes_negative70_followingByte() {
        LongConstant8 lc8 = new LongConstant8((byte) -70);
        Byte[] b = lc8.getBytes();
        assertEquals(2, b.length);
        assertEquals("10000001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10111010", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getSize_zero_twoBytes() {
        LongConstant8 lc8 = new LongConstant8((byte) 0);
        assertEquals(2, lc8.getSize());
    }
}