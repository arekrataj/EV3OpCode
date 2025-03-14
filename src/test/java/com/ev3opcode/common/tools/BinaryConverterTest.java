package com.ev3opcode.common.tools;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class BinaryConverterTest {
    @Test
    public void unpackFrom5Bits_positive10_unpackedByte() {
        Byte b = (byte) 0b1010;
        Byte unpacked = BinaryConverter.unpackFrom5Bits(b);
        assertEquals(10, (long) unpacked);
    }

    @Test
    public void unpackFrom5Bits_positive6_unpackedByte() {
        Byte b = (byte) 0b00000110;
        Byte unpacked = BinaryConverter.unpackFrom5Bits(b);
        assertEquals(6, (long) unpacked);
    }

    @Test
    public void unpackFrom5Bits_negative6_unpackedByte() {
        Byte b = (byte) 0b111010;
        Byte unpacked = BinaryConverter.unpackFrom5Bits(b);
        assertEquals(-6, (long) unpacked);
    }

    @Test
    public void packTo5Bits_positive24_packedByte() {
        Byte b = 24;
        Byte packed = BinaryConverter.packTo5Bits(b);
        assertEquals("00011000", BinaryFormatHelper.byteToBinaryString(packed));
    }

    @Test
    public void packTo5Bits_negative24_packedByte() {
        Byte b = -24;
        Byte packed = BinaryConverter.packTo5Bits(b);
        assertEquals("00101000", BinaryFormatHelper.byteToBinaryString(packed));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shortToTwoBytesLE_negative32768_throwsException() {
        BinaryConverter.shortToTwoBytesLE((short) -32768);
    }

    @Test
    public void shortToTwoBytesLE_positive1984_convertedBytes() {
        Byte[] b = BinaryConverter.shortToTwoBytesLE((short) 1984);
        assertEquals(2, b.length);
        assertEquals("11000000", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00000111", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void shortToTwoBytesLE_negative1984_convertedBytes() {
        Byte[] b = BinaryConverter.shortToTwoBytesLE((short) -1984);
        assertEquals(2, b.length);
        assertEquals("01000000", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("11111000", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void shortFromTwoBytesLE_positive99_convertedShort() {
        Byte[] b = BinaryConverter.shortToTwoBytesLE((short) 99);
        Short converted = BinaryConverter.shortFromTwoBytesLE(b);
        assertEquals("0000000001100011", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(99, (long) converted);
    }

    @Test
    public void shortFromTwoBytesLE_negative99_convertedShort() {
        Byte[] b = BinaryConverter.shortToTwoBytesLE((short) -99);
        Short converted = BinaryConverter.shortFromTwoBytesLE(b);
        assertEquals("1111111110011101", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(-99, (long) converted);
    }

    @Test
    public void shortFromTwoBytesLE_positive2019_convertedShort() {
        Byte[] b = BinaryConverter.shortToTwoBytesLE((short) 2019);
        Short converted = BinaryConverter.shortFromTwoBytesLE(b);
        assertEquals("0000011111100011", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(2019, (long) converted);
    }

    @Test
    public void shortFromTwoBytesLE_negative2019_convertedShort() {
        Byte[] b = BinaryConverter.shortToTwoBytesLE((short) -2019);
        Short converted = BinaryConverter.shortFromTwoBytesLE(b);
        assertEquals("1111100000011101", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(-2019, (long) converted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void intToFourBytesLE_negative2147483648_throwsException() {
        BinaryConverter.intToFourBytesLE(-2147483648);
    }

    @Test
    public void intToFourBytesLE_positive13021984_convertedBytes() {
        Byte[] b = BinaryConverter.intToFourBytesLE(13021984);
        assertEquals(4, b.length);
        assertEquals("00100000", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10110011", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("11000110", BinaryFormatHelper.byteToBinaryString(b[2]));
        assertEquals("00000000", BinaryFormatHelper.byteToBinaryString(b[3]));
    }

    @Test
    public void intToFourBytesLE_negative13021984_convertedBytes() {
        Byte[] b = BinaryConverter.intToFourBytesLE(-13021984);
        assertEquals(4, b.length);
        assertEquals("11100000", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("01001100", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00111001", BinaryFormatHelper.byteToBinaryString(b[2]));
        assertEquals("11111111", BinaryFormatHelper.byteToBinaryString(b[3]));
    }

    @Test
    public void intFromFourBytesLE_positive911_convertedInteger() {
        Byte[] b = BinaryConverter.intToFourBytesLE(911);
        Integer converted = BinaryConverter.intFromFourBytesLE(b);
        assertEquals("00000000000000000000001110001111", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(911, (long) converted);
    }

    @Test
    public void intFromFourBytesLE_negative911_convertedInteger() {
        Byte[] b = BinaryConverter.intToFourBytesLE(-911);
        Integer converted = BinaryConverter.intFromFourBytesLE(b);
        assertEquals("11111111111111111111110001110001", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(-911, (long) converted);
    }

    @Test
    public void intFromFourBytesLE_positive123456789_convertedInteger() {
        Byte[] b = BinaryConverter.intToFourBytesLE(123456789);
        Integer converted = BinaryConverter.intFromFourBytesLE(b);
        assertEquals("00000111010110111100110100010101", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(123456789, (long) converted);
    }

    @Test
    public void intFromFourBytesLE_negative123456789_convertedInteger() {
        Byte[] b = BinaryConverter.intToFourBytesLE(-123456789);
        Integer converted = BinaryConverter.intFromFourBytesLE(b);
        assertEquals("11111000101001000011001011101011", BinaryFormatHelper.intToBinaryString(converted));
        assertEquals(-123456789, (long) converted);
    }

    @Test
    public void floatFromFourBytesLE_1111011_1coma72ExponentMinus43() {
        Byte[] testLE = new Byte[] { 0b1111011, 0, 0, 0 };
        assertEquals(1.72E-43, BinaryConverter.floatFromFourBytesLE(testLE), 0.1);
    }
}