package com.ev3opcode.common.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class ArgumentValueTest {
    private class ShortConstantTestArgument extends ArgumentValue {
        ShortConstantTestArgument(Byte b) {
            setValue(b);
        }
    }

    private class LongConstant8TestArgument extends ArgumentValue {
        LongConstant8TestArgument(Byte b) {
            setValue(b);
        }
    }

    private class LongConstant16TestArgument extends ArgumentValue {
        LongConstant16TestArgument(Short b) {
            setValue(b);
        }
    }

    private class LongConstant32TestArgument extends ArgumentValue {
        LongConstant32TestArgument(Integer b) {
            setValue(b);
        }
    }

    private class LongStringTestArgument extends ArgumentValue {
        LongStringTestArgument(String s) {
            setValue(s);
        }
    }

    private ShortConstantTestArgument m_shortConstantArgument;
    private LongConstant8TestArgument m_longConstant8Argument;
    private LongConstant16TestArgument m_longConstant16Argument;
    private LongConstant32TestArgument m_longConstant32Argument;
    private LongStringTestArgument m_longStringArgument;

    @Before
    public void setUp() throws Exception {
        m_shortConstantArgument = new ShortConstantTestArgument((byte) -6);
        m_longConstant8Argument = new LongConstant8TestArgument((byte) 70);
        m_longConstant16Argument = new LongConstant16TestArgument((short) -1939);
        m_longConstant32Argument = new LongConstant32TestArgument(123456789);
        m_longStringArgument = new LongStringTestArgument("Test");
    }

    @Test
    public void ShortConstantTestArgument_getBytes_byteCode() {
        Byte[] bytes = m_shortConstantArgument.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("00111010", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void LongConstant8TestArgument_getBytes_byteCode() {
        Byte[] bytes = m_longConstant8Argument.getBytes();
        assertEquals(2, bytes.length);
        assertEquals("10000001", BinaryFormatHelper.byteToBinaryString(bytes[0]));
        assertEquals("01000110", BinaryFormatHelper.byteToBinaryString(bytes[1]));
    }

    @Test
    public void LongConstant16TestArgument_getBytes_byteCode() {
        Byte[] bytes = m_longConstant16Argument.getBytes();
        assertEquals(3, bytes.length);
        assertEquals("10000010", BinaryFormatHelper.byteToBinaryString(bytes[0]));
        assertEquals("01101101", BinaryFormatHelper.byteToBinaryString(bytes[1]));
        assertEquals("11111000", BinaryFormatHelper.byteToBinaryString(bytes[2]));
    }

    @Test
    public void LongConstant32TestArgument_getBytes_byteCode() {
        Byte[] bytes = m_longConstant32Argument.getBytes();
        assertEquals(5, bytes.length);
        assertEquals("10000011", BinaryFormatHelper.byteToBinaryString(bytes[0]));
        assertEquals("00010101", BinaryFormatHelper.byteToBinaryString(bytes[1]));
        assertEquals("11001101", BinaryFormatHelper.byteToBinaryString(bytes[2]));
        assertEquals("01011011", BinaryFormatHelper.byteToBinaryString(bytes[3]));
        assertEquals("00000111", BinaryFormatHelper.byteToBinaryString(bytes[4]));
    }

    @Test
    public void LongStringTestArgument_getBytes_byteCode() {
        Byte[] bytes = m_longStringArgument.getBytes();
        assertEquals(6, bytes.length);
        assertEquals("10000100", BinaryFormatHelper.byteToBinaryString(bytes[0]));
        assertEquals('T', bytes[1].byteValue());
        assertEquals('e', bytes[2].byteValue());
        assertEquals('s', bytes[3].byteValue());
        assertEquals('t', bytes[4].byteValue());
        assertEquals('\0', bytes[5].byteValue());
    }

    @Test
    public void LongStringTestArgument_getSize_sixBytes() {
        assertEquals(6, m_longStringArgument.getSize());
    }
}