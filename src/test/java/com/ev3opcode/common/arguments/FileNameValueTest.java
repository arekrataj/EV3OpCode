package com.ev3opcode.common.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileNameValueTest {
    private FileNameValue m_fileName;

    @Before
    public void setUp() throws Exception {
        m_fileName = new FileNameValue("TestFileName");
    }

    @Test
    public void getName_returnsTestFileName() {
        assertEquals("TestFileName", m_fileName.getName());
    }

    @Test
    public void setName_FileName_setsValue() {
        m_fileName.setName("FileName");
        assertEquals("FileName", m_fileName.getName());
    }
}