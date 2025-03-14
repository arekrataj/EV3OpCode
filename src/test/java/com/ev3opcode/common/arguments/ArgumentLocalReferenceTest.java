package com.ev3opcode.common.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class ArgumentLocalReferenceTest {
    private class ShortLocalVariableTestArgument extends ArgumentLocalReference {
        ShortLocalVariableTestArgument(Byte b) {
            super(b);
        }
    }

    private class LongLocalVariable8TestArgument extends ArgumentLocalReference {
        LongLocalVariable8TestArgument(Byte b) {
            super(b);
        }
    }

    private class LongLocalVariable16TestArgument extends ArgumentLocalReference {
        LongLocalVariable16TestArgument(Short b) {
            super(b);
        }
    }

    private class LongLocalVariable32TestArgument extends ArgumentLocalReference {
        LongLocalVariable32TestArgument(Integer b) {
            super(b);
        }
    }

    private ShortLocalVariableTestArgument m_shortLocalVariableArgument;
    private LongLocalVariable8TestArgument m_longLocalVariable8Argument;
    private LongLocalVariable16TestArgument m_longLocalVariable16Argument;
    private LongLocalVariable32TestArgument m_longLocalVariable32Argument;

    @Before
    public void setUp() throws Exception {
        m_shortLocalVariableArgument = new ShortLocalVariableTestArgument((byte) 31);
        m_longLocalVariable8Argument = new LongLocalVariable8TestArgument((byte) -70);
        m_longLocalVariable16Argument = new LongLocalVariable16TestArgument((short) 1939);
        m_longLocalVariable32Argument = new LongLocalVariable32TestArgument(-123456789);
    }

    @Test
    public void ShortLocalVariableTestArgument_getBytes_byteCode() {
        Byte[] bytes = m_shortLocalVariableArgument.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("01011111", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void LongLocalVariable8TestArgument_getBytes_byteCode() {
        Byte[] b = m_longLocalVariable8Argument.getBytes();
        assertEquals(2, b.length);
        assertEquals("11000001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10111010", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void LongLocalVariable16TestArgument_getBytes_byteCode() {
        Byte[] b = m_longLocalVariable16Argument.getBytes();
        assertEquals(3, b.length);
        assertEquals("11000010", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10010011", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00000111", BinaryFormatHelper.byteToBinaryString(b[2]));
    }

    @Test
    public void LongLocalVariable32TestArgument_getBytes_byteCode() {
        Byte[] b = m_longLocalVariable32Argument.getBytes();
        assertEquals(5, b.length);
        assertEquals("11000011", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("11101011", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00110010", BinaryFormatHelper.byteToBinaryString(b[2]));
        assertEquals("10100100", BinaryFormatHelper.byteToBinaryString(b[3]));
        assertEquals("11111000", BinaryFormatHelper.byteToBinaryString(b[4]));
    }
}