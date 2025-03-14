package com.ev3opcode.commands.output.arguments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MotorBitFieldValueTest {
    private MotorBitFieldValue m_bitField;

    @Before
    public void setUp() throws Exception {
        m_bitField = new MotorBitFieldValue(false, true, true, false);
    }

    @Test
    public void isSetMotorA_returnsFalse() {
        assertFalse(m_bitField.isSetMotorA());
    }

    @Test
    public void isSetMotorB_returnsTrue() {
        assertTrue(m_bitField.isSetMotorB());
    }

    @Test
    public void isSetMotorC_returnsTrue() {
        assertTrue(m_bitField.isSetMotorC());
    }

    @Test
    public void isSetMotorD_returnsFalse() {
        assertFalse(m_bitField.isSetMotorD());
    }

    @Test
    public void setMotors_TFFT_setsValues() {
        m_bitField.setMotors(true, false, false, true);

        assertTrue(m_bitField.isSetMotorA());
        assertFalse(m_bitField.isSetMotorB());
        assertFalse(m_bitField.isSetMotorC());
        assertTrue(m_bitField.isSetMotorD());
    }
}