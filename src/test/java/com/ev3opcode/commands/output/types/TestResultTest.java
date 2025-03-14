package com.ev3opcode.commands.output.types;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestResultTest {
    @Test
    public void isBusyPortA_notSet_returnsFalse() {
        TestResult test = new TestResult((byte) 0);
        assertFalse(test.isBusyPortA());
    }

    @Test
    public void isBusyPortA_set_returnsTrue() {
        TestResult test = new TestResult((byte) 1);
        assertTrue(test.isBusyPortA());
    }

    @Test
    public void isBusyPortB_notSet_returnsFalse() {
        TestResult test = new TestResult((byte) 1);
        assertFalse(test.isBusyPortB());
    }

    @Test
    public void isBusyPortB_set_returnsTrue() {
        TestResult test = new TestResult((byte) 2);
        assertTrue(test.isBusyPortB());
    }

    @Test
    public void isBusyPortC_notSet_returnsFalse() {
        TestResult test = new TestResult((byte) 2);
        assertFalse(test.isBusyPortC());
    }

    @Test
    public void isBusyPortC_set_returnsTrue() {
        TestResult test = new TestResult((byte) 4);
        assertTrue(test.isBusyPortC());
    }

    @Test
    public void isBusyPortD_notSet_returnsFalse() {
        TestResult test = new TestResult((byte) 5);
        assertFalse(test.isBusyPortD());
    }

    @Test
    public void isBusyPortD_set_returnsTrue() {
        TestResult test = new TestResult((byte) 8);
        assertTrue(test.isBusyPortD());
    }
}