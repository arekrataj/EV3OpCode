package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class LongConstant16Test {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative32768_throwsException() {
        new LongConstant16((short) -32768);
    }

    @Test
    public void getBytes_zero_following2Bytes() {
        LongConstant16 lc16 = new LongConstant16((short) 0);
        Byte[] b = lc16.getBytes();
        assertEquals(3, b.length);
        assertEquals("10000010", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[2]));
    }

    @Test
    public void getBytes_positive1939_following2Bytes() {
        LongConstant16 lc16 = new LongConstant16((short) 1939);
        Byte[] b = lc16.getBytes();
        assertEquals(3, b.length);
        assertEquals("10000010", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10010011", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00000111", BinaryFormatHelper.byteToBinaryString(b[2]));
    }

    @Test
    public void getBytes_negative1939_following2Bytes() {
        LongConstant16 lc16 = new LongConstant16((short) -1939);
        Byte[] b = lc16.getBytes();
        assertEquals(3, b.length);
        assertEquals("10000010", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("01101101", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("11111000", BinaryFormatHelper.byteToBinaryString(b[2]));
    }

    @Test
    public void getSize_zero_threeBytes() {
        LongConstant16 lc16 = new LongConstant16((short) 0);
        assertEquals(3, lc16.getSize());
    }
}