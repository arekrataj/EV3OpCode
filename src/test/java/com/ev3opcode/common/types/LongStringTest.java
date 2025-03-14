package com.ev3opcode.common.types;

import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class LongStringTest {
    @Test
    public void getBytes_emptyString_flagAndTerminationChar() {
        LongString empty = new LongString();
        Byte[] bytes = empty.getBytes();
        assertEquals(2, bytes.length);
        assertEquals("10000100", BinaryFormatHelper.byteToBinaryString(bytes[0]));
        assertEquals('\0', bytes[1].byteValue());
    }

    @Test
    public void getBytes_testText_flagBytesArrayZeroTerminated() {
        LongString longString = new LongString("Test");
        Byte[] bytes = longString.getBytes();
        assertEquals(6, bytes.length);
        assertEquals("10000100", BinaryFormatHelper.byteToBinaryString(bytes[0]));
        assertEquals('T', bytes[1].byteValue());
        assertEquals('e', bytes[2].byteValue());
        assertEquals('s', bytes[3].byteValue());
        assertEquals('t', bytes[4].byteValue());
        assertEquals('\0', bytes[5].byteValue());
    }

    @Test
    public void getValue_string_sameString() {
        String testString = "Test";
        LongString longString = new LongString(testString);
        assertEquals(testString, longString.getValue());
    }

    @Test
    public void getSize_testText_sixBytes() {
        LongString longString = new LongString("Test");
        assertEquals(6, longString.getSize());
    }
}