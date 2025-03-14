package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class LongLocalVariable8Test {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative128_throwsException() {
        LongLocalVariable8 lv8 = new LongLocalVariable8();
        lv8.setValue((byte) -128);
    }

    @Test
    public void getBytes_zero_followingByte() {
        LongLocalVariable8 lv8 = new LongLocalVariable8((byte) 0);
        Byte[] b = lv8.getBytes();
        assertEquals(2, b.length);
        assertEquals("11000001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getBytes_positive70_followingByte() {
        LongLocalVariable8 lv8 = new LongLocalVariable8((byte) 70);
        Byte[] b = lv8.getBytes();
        assertEquals(2, b.length);
        assertEquals("11000001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("01000110", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getBytes_negative70_followingByte() {
        LongLocalVariable8 lv8 = new LongLocalVariable8((byte) -70);
        Byte[] b = lv8.getBytes();
        assertEquals(2, b.length);
        assertEquals("11000001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10111010", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getSize_zero_twoBytes() {
        LongLocalVariable8 lv8 = new LongLocalVariable8((byte) 0);
        assertEquals(2, lv8.getSize());
    }
}