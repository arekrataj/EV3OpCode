package com.ev3opcode.common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectResponseTest {
    private Byte[] m_emptyResponse = new Byte[] { 0x3, 0x0, 0x0, 0x1, 0x2 };
    private DirectResponse m_empty;

    private Byte[] m_responseBytes = new Byte[] { 0x7, 0x0, 0x3, 0x0, 0x4, 'T', 'e', 's', 't' };
    private DirectResponse m_response;

    @Before
    public void setUp() throws Exception {
        m_empty = DirectResponse.fromByteCode(m_emptyResponse);
        m_response = DirectResponse.fromByteCode(m_responseBytes);
    }

    @Test(expected = RuntimeException.class)
    public void fromByteCode_byteCodeLengthLessThan5_throwsException() {
        DirectResponse.fromByteCode(new Byte[] {});
    }

    @Test
    public void fromByteCode_empty_size3bytes() {
        assertEquals(3, m_empty.getSize());
    }

    @Test
    public void fromByteCode_empty_messageNumber256() {
        assertEquals(256, m_empty.getMessageNumber());
    }

    @Test
    public void fromByteCode_empty_ResponseTypeOK() {
        assertEquals(DirectResponseType.OK, m_empty.getResponseType());
    }

    @Test
    public void fromByteCode_empty_emptyResponseBuffer() {
        assertEquals(0, m_empty.getResponseBuffer().getSize());
    }

    @Test
    public void fromByteCode_response_size7bytes() {
        assertEquals(7, m_response.getSize());
    }

    @Test
    public void fromByteCode_response_messageNumber3() {
        assertEquals(3, m_response.getMessageNumber());
    }

    @Test
    public void fromByteCode_response_ResponseTypeOK() {
        assertEquals(DirectResponseType.ERROR, m_response.getResponseType());
    }

    @Test
    public void fromByteCode_response_responseBuffer() {
        Byte[] readBytes = m_response.getResponseBuffer().read(0, 4);
        assertEquals(4, readBytes.length);
        assertEquals('T', (byte) readBytes[0]);
        assertEquals('e', (byte) readBytes[1]);
        assertEquals('s', (byte) readBytes[2]);
        assertEquals('t', (byte) readBytes[3]);
    }
}