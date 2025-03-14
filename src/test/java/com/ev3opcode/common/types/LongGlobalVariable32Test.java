package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class LongGlobalVariable32Test {
    @Test(expected = IllegalArgumentException.class)
    public void setValue_negative2147483648_throwsException() {
        LongGlobalVariable32 lg32 = new LongGlobalVariable32();
        lg32.setValue(-2147483648);
    }

    @Test
    public void getBytes_zero_following4Bytes() {
        LongGlobalVariable32 lg32 = new LongGlobalVariable32(0);
        Byte[] b = lg32.getBytes();
        assertEquals(5, b.length);
        assertEquals("11100011", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[2]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[3]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[4]));
    }

    @Test
    public void getBytes_positive123456789_following4Bytes() {
        LongGlobalVariable32 lg32 = new LongGlobalVariable32(123456789);
        Byte[] b = lg32.getBytes();
        assertEquals(5, b.length);
        assertEquals("11100011", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00010101", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("11001101", BinaryFormatHelper.byteToBinaryString(b[2]));
        assertEquals("01011011", BinaryFormatHelper.byteToBinaryString(b[3]));
        assertEquals("00000111", BinaryFormatHelper.byteToBinaryString(b[4]));
    }

    @Test
    public void getBytes_negative123456789_following4Bytes() {
        LongGlobalVariable32 lg32 = new LongGlobalVariable32(-123456789);
        Byte[] b = lg32.getBytes();
        assertEquals(5, b.length);
        assertEquals("11100011", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("11101011", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00110010", BinaryFormatHelper.byteToBinaryString(b[2]));
        assertEquals("10100100", BinaryFormatHelper.byteToBinaryString(b[3]));
        assertEquals("11111000", BinaryFormatHelper.byteToBinaryString(b[4]));
    }

    @Test
    public void getSize_zero_fiveBytes() {
        LongGlobalVariable32 lg32 = new LongGlobalVariable32(0);
        assertEquals(5, lg32.getSize());
    }
}