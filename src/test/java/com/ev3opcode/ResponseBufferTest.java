package com.ev3opcode;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.common.ResponseBuffer;

import static org.junit.Assert.assertEquals;

public class ResponseBufferTest {
    private ResponseBuffer m_responseBuffer;

    @Before
    public void setUp() throws Exception {
        Byte[] buffer = new Byte[] { 'T', 'e', 's', 't' };
        m_responseBuffer = new ResponseBuffer(buffer);
    }

    @Test(expected = RuntimeException.class)
    public void read_zeroBuffer_throwsException() {
        ResponseBuffer tmp = new ResponseBuffer(new Byte[0]);
        tmp.read(1, 2);
    }

    @Test(expected = RuntimeException.class)
    public void read_lengthExceedsBufferSize_throwsException() {
        m_responseBuffer.read(1, 12);
    }

    @Test(expected = RuntimeException.class)
    public void read_startExceedsBufferSize_throwsException() {
        m_responseBuffer.read(12, 0);
    }

    @Test
    public void read_oneByte_oneByte() {
        Byte[] readBytes = m_responseBuffer.read(1, 1);
        assertEquals(1, readBytes.length);
        assertEquals('e', (byte) readBytes[0]);
    }

    @Test
    public void read_lastByte_oneByte() {
        Byte[] readBytes = m_responseBuffer.read(3, 1);
        assertEquals(1, readBytes.length);
        assertEquals('t', (byte) readBytes[0]);
    }

    @Test
    public void read_wholeBuffer_fourBytes() {
        Byte[] readBytes = m_responseBuffer.read(0, 4);
        assertEquals(4, readBytes.length);
        assertEquals('T', (byte) readBytes[0]);
        assertEquals('e', (byte) readBytes[1]);
        assertEquals('s', (byte) readBytes[2]);
        assertEquals('t', (byte) readBytes[3]);
    }

    @Test
    public void getSize_buffer_4() {
        assertEquals(4, m_responseBuffer.getSize());
    }
}