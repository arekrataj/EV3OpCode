package com.ev3opcode.common.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.helpers.BinaryFormatHelper;

import static org.junit.Assert.assertEquals;

public class ArgumentGlobalReferenceTest {
    private class ShortGlobalVariableTestArgument extends ArgumentGlobalReference {
        ShortGlobalVariableTestArgument(Byte b) {
            super(b);
        }
    }

    private class LongGlobalVariable8TestArgument extends ArgumentGlobalReference {
        LongGlobalVariable8TestArgument(Byte b) {
            super(b);
        }
    }

    private class LongGlobalVariable16TestArgument extends ArgumentGlobalReference {
        LongGlobalVariable16TestArgument(Short b) {
            super(b);
        }
    }

    private class LongGlobalVariable32TestArgument extends ArgumentGlobalReference {
        LongGlobalVariable32TestArgument(Integer b) {
            super(b);
        }
    }

    private ShortGlobalVariableTestArgument m_shortGlobalVariableArgument;
    private LongGlobalVariable8TestArgument m_longGlobalVariable8Argument;
    private LongGlobalVariable16TestArgument m_longGlobalVariable16Argument;
    private LongGlobalVariable32TestArgument m_longGlobalVariable32Argument;

    @Before
    public void setUp() throws Exception {
        m_shortGlobalVariableArgument = new ShortGlobalVariableTestArgument((byte) 31);
        m_longGlobalVariable8Argument = new LongGlobalVariable8TestArgument((byte) 70);
        m_longGlobalVariable16Argument = new LongGlobalVariable16TestArgument((short) 1939);
        m_longGlobalVariable32Argument = new LongGlobalVariable32TestArgument(123456789);
    }

    @Test
    public void ShortGlobalVariableTestArgument_getBytes_byteCode() {
        Byte[] bytes = m_shortGlobalVariableArgument.getBytes();
        assertEquals(1, bytes.length);
        Byte b = bytes[0];
        assertEquals("01111111", BinaryFormatHelper.byteToBinaryString(b));
    }

    @Test
    public void LongGlobalVariable8TestArgument_getBytes_byteCode() {
        Byte[] b = m_longGlobalVariable8Argument.getBytes();
        assertEquals(2, b.length);
        assertEquals("11100001", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("01000110", BinaryFormatHelper.byteToBinaryString(b[1]));
    }

    @Test
    public void LongGlobalVariable16TestArgument_getBytes_byteCode() {
        Byte[] b = m_longGlobalVariable16Argument.getBytes();
        assertEquals(3, b.length);
        assertEquals("11100010", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("10010011", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("00000111", BinaryFormatHelper.byteToBinaryString(b[2]));
    }

    @Test
    public void LongGlobalVariable32TestArgument_getBytes_byteCode() {
        Byte[] b = m_longGlobalVariable32Argument.getBytes();
        assertEquals(5, b.length);
        assertEquals("11100011", BinaryFormatHelper.byteToBinaryString(b[0]));
        assertEquals("00010101", BinaryFormatHelper.byteToBinaryString(b[1]));
        assertEquals("11001101", BinaryFormatHelper.byteToBinaryString(b[2]));
        assertEquals("01011011", BinaryFormatHelper.byteToBinaryString(b[3]));
        assertEquals("00000111", BinaryFormatHelper.byteToBinaryString(b[4]));
    }
}