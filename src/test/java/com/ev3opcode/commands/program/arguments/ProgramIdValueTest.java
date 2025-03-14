package com.ev3opcode.commands.program.arguments;

import org.junit.Before;
import org.junit.Test;

import com.ev3opcode.commands.program.types.ProgramID;

import static org.junit.Assert.assertEquals;

public class ProgramIdValueTest {
    private ProgramIdValue m_programId;

    @Before
    public void setUp() throws Exception {
        m_programId = new ProgramIdValue(ProgramID.TERM_SLOT);
    }

    @Test
    public void getProgramId_returnsTermSLot() {
        assertEquals(ProgramID.TERM_SLOT, m_programId.getProgramID());
    }

    @Test
    public void setProgramId_guiSlot_setsValue() {
        m_programId.setProgramID(ProgramID.GUI_SLOT);
        assertEquals(ProgramID.GUI_SLOT, m_programId.getProgramID());
    }
}