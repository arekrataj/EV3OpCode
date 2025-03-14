package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class LongGlobalVariable8Test {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative128_throwsException() {
        LongGlobalVariable8 lg8 = new LongGlobalVariable8();
        lg8.setValue((byte) -128);
    }

    @Test
    public void getBytes_zero_followingByte() {
        LongGlobalVariable8 lg8 = new LongGlobalVariable8((byte) 0);
        Byte[] b = lg8.getBytes();
        assertEquals(2, b.length);
        assertEquals("11100001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getBytes_positive70_followingByte() {
        LongGlobalVariable8 lg8 = new LongGlobalVariable8((byte) 70);
        Byte[] b = lg8.getBytes();
        assertEquals(2, b.length);
        assertEquals("11100001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("01000110", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getBytes_negative70_followingByte() {
        LongGlobalVariable8 lg8 = new LongGlobalVariable8((byte) -70);
        Byte[] b = lg8.getBytes();
        assertEquals(2, b.length);
        assertEquals("11100001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10111010", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void getSize_zero_twoBytes() {
        LongGlobalVariable8 lg8 = new LongGlobalVariable8((byte) 0);
        assertEquals(2, lg8.getSize());
    }
}